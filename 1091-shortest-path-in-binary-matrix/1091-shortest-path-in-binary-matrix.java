import java.util.*;

class Solution {

    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1});
        grid[0][0] = 1;
        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           {0, 1},
            {1, -1},  {1, 0},  {1, 1}
        };

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int r = current[0];
            int c = current[1];
            int distance = current[2];
            if (r == n - 1 && c == n - 1) {
                return distance;
            }

            for (int[] dir : directions) {

                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr < 0 || nr >= n ||
                    nc < 0 || nc >= n) {
                    continue;
                }
                if (grid[nr][nc] == 1) {
                    continue;
                }
                grid[nr][nc] = 1;

                queue.offer(new int[]{
                    nr,
                    nc,
                    distance + 1
                });
            }
        }

        return -1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna