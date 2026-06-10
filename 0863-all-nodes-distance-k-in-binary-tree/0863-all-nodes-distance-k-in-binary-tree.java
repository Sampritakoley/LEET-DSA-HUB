/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
     Map<Integer, List<Integer>> graph = new HashMap<>();
    List<Integer> result = new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        buildGraph(root, null);
        Set<Integer> visited = new HashSet<>();
        dfs(target.val, k, visited);
        return result;
    }
    private void dfs(int node, int k, Set<Integer> visited) {
        if (visited.contains(node))
            return;
        visited.add(node);
        if (k == 0) {
            result.add(node);
            return;
        }
        for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            dfs(neighbor, k - 1, visited);
        }
    }
    private void buildGraph(TreeNode node, TreeNode parent) {
        if (node == null) return;
        graph.putIfAbsent(node.val, new ArrayList<>());
        if (parent != null) {
            graph.putIfAbsent(parent.val, new ArrayList<>());

            graph.get(node.val).add(parent.val);
            graph.get(parent.val).add(node.val);
        }
        buildGraph(node.left, node);
        buildGraph(node.right, node);
    }
}