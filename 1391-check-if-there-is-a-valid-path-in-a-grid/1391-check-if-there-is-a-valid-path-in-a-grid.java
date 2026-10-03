class Solution {

    public boolean hasValidPath(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {
            {},
            {1, 3}, 
            {0, 2}, 
            {3, 2}, 
            {1, 2}, 
            {3, 0}, 
            {1, 0} 
        };

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        boolean[][] visited = new boolean[m][n];

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int r = curr[0];
            int c = curr[1];

            if (r == m - 1 && c == n - 1) {
                return true;
            }

            int street = grid[r][c];

            for (int dir : dirs[street]) {

                int nr = r + dr[dir];
                int nc = c + dc[dir];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }

                if (visited[nr][nc]) {
                    continue;
                }
                int opposite = (dir + 2) % 4;
                boolean connected = false;

                for (int nextDir : dirs[grid[nr][nc]]) {
                    if (nextDir == opposite) {
                        connected = true;
                        break;
                    }
                }

                if (connected) {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        return false;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna