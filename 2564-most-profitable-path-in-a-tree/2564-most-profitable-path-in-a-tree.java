import java.util.*;

public class Solution {
    private Map<Integer, List<Integer>> graph = new HashMap<>();
    private int[] bobTime;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;

        // Step 1: Build graph (adjacency list)
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], x -> new ArrayList<>()).add(edge[0]);
        }

        // Step 2: Track Bob's arrival time to each node
        bobTime = new int[n];
        Arrays.fill(bobTime, Integer.MAX_VALUE);
        findBobPath(bob, -1, 0);

        // Step 3: Alice DFS to calculate max income
        return dfs(0, -1, 0, 0, amount);
    }

    // DFS to compute when Bob reaches each node
    private boolean findBobPath(int node, int parent, int time) {
        if (node == 0) {
            bobTime[node] = time;
            return true;
        }

        for (int neighbor : graph.get(node)) {
            if (neighbor == parent) continue;
            if (findBobPath(neighbor, node, time + 1)) {
                bobTime[node] = time;
                return true;
            }
        }
        return false;
    }

    // DFS from Alice's side to compute max profit path
    private int dfs(int node, int parent, int time, int currentSum, int[] amount) {
        if (time < bobTime[node]) {
            currentSum += amount[node]; // Alice gets full reward
        } else if (time == bobTime[node]) {
            currentSum += amount[node] / 2; // Split
        } // Else Bob already took it, Alice gets nothing

        int maxProfit = Integer.MIN_VALUE;
        boolean isLeaf = true;

        for (int neighbor : graph.get(node)) {
            if (neighbor == parent) continue;
            isLeaf = false;
            maxProfit = Math.max(maxProfit, dfs(neighbor, node, time + 1, currentSum, amount));
        }

        return isLeaf ? currentSum : maxProfit;
    }
}
