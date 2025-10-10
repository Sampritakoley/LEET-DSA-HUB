class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        Queue<int[]> pacQueue = new LinkedList<>();
        Queue<int[]> atlQueue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            pacQueue.offer(new int[]{i, 0});
            pacific[i][0] = true;
        }
        for (int j = 0; j < n; j++) {
            pacQueue.offer(new int[]{0, j});
            pacific[0][j] = true;
        }
        for (int i = 0; i < m; i++) {
            atlQueue.offer(new int[]{i, n - 1});
            atlantic[i][n - 1] = true;
        }
        for (int j = 0; j < n; j++) {
            atlQueue.offer(new int[]{m - 1, j});
            atlantic[m - 1][j] = true;
        }
        bfs(heights,pacific,pacQueue);
        bfs(heights,atlantic,atlQueue);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;

    }
    private void bfs(int[][] heights, boolean[][] visited, Queue<int[]> queue) {
        int m = heights.length;
        int n = heights[0].length;
        int[] x=new int[]{1,-1,0,0};
        int[] y=new int[]{0,0,1,-1};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];

            for (int k=0;k<4;k++) {
                int nr = r + x[k];
                int nc = c + y[k];

                if (nr < 0 || nc < 0 || nr >= m || nc >= n || visited[nr][nc])            continue;

                if (heights[nr][nc] >= heights[r][c]) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }
}