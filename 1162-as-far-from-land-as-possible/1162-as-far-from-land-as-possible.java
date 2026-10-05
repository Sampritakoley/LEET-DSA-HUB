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

    public int maxDistance(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 1) {
                    queue.offer(new Pair(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }
        if (queue.isEmpty() || queue.size() == n * m) {
            return -1;
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int maxDist = -1;

        while (!queue.isEmpty()) {

            Pair curr = queue.poll();

            maxDist = Math.max(maxDist, curr.dist);

            for (int k = 0; k < 4; k++) {

                int nr = curr.row + dx[k];
                int nc = curr.col + dy[k];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }

                if (!visited[nr][nc]) {

                    visited[nr][nc] = true;

                    queue.offer(
                        new Pair(nr, nc, curr.dist + 1)
                    );
                }
            }
        }

        return maxDist;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna