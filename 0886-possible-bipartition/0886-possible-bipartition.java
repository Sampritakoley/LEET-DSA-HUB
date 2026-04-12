class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] graph = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] d : dislikes) {
            int u = d[0];
            int v = d[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        
        int[] color = new int[n + 1];
        Arrays.fill(color, -1);
        
        for (int i = 1; i <= n; i++) {
            if (color[i] == -1) {
                if (!bfs(graph, i, color)) {
                    return false;
                }
            }
        }
        
        return true;
    }

    private boolean bfs(List<Integer>[] graph, int start, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        color[start] = 0;
        
        while (!q.isEmpty()) {
            int node = q.poll();
            
            for (int neighbor : graph[node]) {
                if (color[neighbor] == -1) {
                    color[neighbor] = 1 - color[node];
                    q.offer(neighbor);
                } else if (color[neighbor] == color[node]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}