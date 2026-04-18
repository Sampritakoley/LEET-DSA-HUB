class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
         int n = graph.length;

        List<List<Integer>> reverse = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            reverse.add(new ArrayList<>());
        }

        int[] outdegree = new int[n];

        for (int i = 0; i < n; i++) {
            outdegree[i] = graph[i].length;
            for (int neighbor : graph[i]) {
                reverse.get(neighbor).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (outdegree[i] == 0) {
                q.offer(i);
            }
        }

        boolean[] safe = new boolean[n];
        while (!q.isEmpty()) {
            int node = q.poll();
            safe[node] = true;

            for (int prev : reverse.get(node)) {
                outdegree[prev]--;
                if (outdegree[prev] == 0) {
                    q.offer(prev);
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (safe[i]) result.add(i);
        }

        return result;
    }
}