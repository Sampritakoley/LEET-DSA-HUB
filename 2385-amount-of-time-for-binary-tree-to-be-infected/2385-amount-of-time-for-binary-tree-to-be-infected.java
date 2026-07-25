class Solution {

    Map<Integer, List<Integer>> graph = new HashMap<>();

    public int amountOfTime(TreeNode root, int start) {

        buildGraph(root, null);

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(start);
        visited.add(start);

        int minutes = -1;

        while (!queue.isEmpty()) {

            int size = queue.size();
            minutes++;

            while (size-- > 0) {

                int node = queue.poll();

                for (int next : graph.getOrDefault(node, new ArrayList<>())) {

                    if (!visited.contains(next)) {

                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }
        }

        return minutes;
    }

    private void buildGraph(TreeNode node, TreeNode parent) {

        if (node == null)
            return;

        graph.putIfAbsent(node.val, new ArrayList<>());

        if (parent != null) {

            graph.get(node.val).add(parent.val);

            graph.putIfAbsent(parent.val, new ArrayList<>());

            graph.get(parent.val).add(node.val);
        }

        buildGraph(node.left, node);

        buildGraph(node.right, node);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna