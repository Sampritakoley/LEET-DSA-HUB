class Solution {
   public int[] shortestAlternatingPaths(
            int n,
            int[][] redEdges,
            int[][] blueEdges) {
        List<Integer>[][] graph = new ArrayList[2][n];

        for (int color = 0; color < 2; color++) {
            for (int i = 0; i < n; i++) {
                graph[color][i] = new ArrayList<>();
            }
        }
        for (int[] edge : redEdges) {
            int u = edge[0];
            int v = edge[1];
            graph[0][u].add(v);
        }
        for (int[] edge : blueEdges) {
            int u = edge[0];
            int v = edge[1];
            graph[1][u].add(v);
        }
        int[][] dist = new int[n][2];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }

        Queue<int[]> queue = new LinkedList<>();
        dist[0][0] = 0;
        dist[0][1] = 0;

        queue.offer(new int[]{0, 0});
        queue.offer(new int[]{0, 1}); 

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int node = current[0];
            int lastColor = current[1];
            int nextColor = 1 - lastColor;

            for (int nextNode : graph[nextColor][node]) {
                if (dist[nextNode][nextColor] == -1) {

                    dist[nextNode][nextColor] =
                            dist[node][lastColor] + 1;

                    queue.offer(
                            new int[]{nextNode, nextColor}
                    );
                }
            }
        }

        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {

            if (dist[i][0] == -1) {
                answer[i] = dist[i][1];
            } 
            else if (dist[i][1] == -1) {
                answer[i] = dist[i][0];
            } 
            else {
                answer[i] = Math.min(
                        dist[i][0],
                        dist[i][1]
                );
            }
        }

        return answer;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna