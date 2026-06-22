import java.util.*;

class Solution {

    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer>[] graph;

    private int[] disc;
    private int[] low;

    private int time = 0;

    public List<List<Integer>> criticalConnections(
            int n,
            List<List<Integer>> connections) {

        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (List<Integer> edge : connections) {

            int u = edge.get(0);
            int v = edge.get(1);

            graph[u].add(v);
            graph[v].add(u);
        }

        disc = new int[n];
        low = new int[n];

        Arrays.fill(disc, -1);

        dfs(0, -1);

        return result;
    }

    private void dfs(int node, int parent) {

        disc[node] = low[node] = time++;

        for (int neighbor : graph[node]) {

            if (neighbor == parent)
                continue;

            if (disc[neighbor] != -1) {

                low[node] =
                    Math.min(low[node], disc[neighbor]);
            }

            else {

                dfs(neighbor, node);

                low[node] =
                    Math.min(low[node], low[neighbor]);

                if (low[neighbor] > disc[node]) {

                    result.add(
                        Arrays.asList(node, neighbor)
                    );
                }
            }
        }
    }
}