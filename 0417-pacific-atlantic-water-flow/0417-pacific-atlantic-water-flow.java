class Solution {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            dfs(i, 0, heights, pacific);
        }

        for (int j = 0; j < m; j++) {
            dfs(0, j, heights, pacific);
        }
        for (int i = 0; i < n; i++) {
            dfs(i, m - 1, heights, atlantic);
        }

        for (int j = 0; j < m; j++) {
            dfs(n - 1, j, heights, atlantic);
        }
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(
        int row,
        int col,
        int[][] heights,
        boolean[][] visited
    ) {

        int n = heights.length;
        int m = heights[0].length;

        visited[row][col] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int k = 0; k < 4; k++) {

            int nr = row + dx[k];
            int nc = col + dy[k];
            if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                continue;
            }
            if (visited[nr][nc]) {
                continue;
            }
            if (heights[nr][nc] < heights[row][col]) {
                continue;
            }

            dfs(nr, nc, heights, visited);
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna