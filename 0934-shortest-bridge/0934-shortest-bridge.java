class Solution {

    class Pair {
        int row;
        int col;
        int dist;

        Pair(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    public int shortestBridge(int[][] grid) {

        int n = grid.length;

        boolean[][] visited = new boolean[n][n];

        Queue<Pair> queue = new LinkedList<>();
        boolean found = false;

        for (int i = 0; i < n && !found; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {

                    dfs(i, j, grid, visited, queue);

                    found = true;
                    break;
                }
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {

            Pair curr = queue.poll();

            for (int k = 0; k < 4; k++) {

                int nr = curr.row + dx[k];
                int nc = curr.col + dy[k];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
                    continue;
                }

                if (grid[nr][nc] == 1 && !visited[nr][nc]) {
                    return curr.dist;
                }
                if (grid[nr][nc] == 0 && !visited[nr][nc]) {

                    visited[nr][nc] = true;

                    queue.offer(
                        new Pair(nr, nc, curr.dist + 1)
                    );
                }
            }
        }

        return -1;
    }

    private void dfs(
        int row,
        int col,
        int[][] grid,
        boolean[][] visited,
        Queue<Pair> queue
    ) {

        int n = grid.length;

        if (row < 0 || row >= n ||
            col < 0 || col >= n ||
            visited[row][col] ||
            grid[row][col] == 0) {
            return;
        }

        visited[row][col] = true;
        queue.offer(new Pair(row, col, 0));

        dfs(row - 1, col, grid, visited, queue);
        dfs(row + 1, col, grid, visited, queue);
        dfs(row, col - 1, grid, visited, queue);
        dfs(row, col + 1, grid, visited, queue);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna