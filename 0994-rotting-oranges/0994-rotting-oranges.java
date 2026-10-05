import java.util.*;

class Solution {

    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        int fresh = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                }

                if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }

        int minutes = 0;

        int[][] directions = {
            {-1, 0}, 
            {1, 0},  
            {0, -1}, 
            {0, 1}   
        };
        while (!queue.isEmpty() && fresh > 0) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {

                int[] current = queue.poll();

                int r = current[0];
                int c = current[1];

                for (int[] dir : directions) {

                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if (nr < 0 || nr >= m ||
                        nc < 0 || nc >= n) {
                        continue;
                    }
                    if (grid[nr][nc] != 1) {
                        continue;
                    }
                    grid[nr][nc] = 2;

                    fresh--;

                    queue.offer(new int[]{nr, nc});
                }
            }

            minutes++;
        }
        if (fresh > 0) {
            return -1;
        }

        return minutes;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna