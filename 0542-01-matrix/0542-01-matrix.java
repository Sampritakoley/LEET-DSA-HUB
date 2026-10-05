import java.util.*;

class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                if (mat[r][c] == 0) {
                    queue.offer(new int[]{r, c});
                } else {
                    mat[r][c] = -1; 
                }
            }
        }

        int[][] directions = {
            {-1, 0}, 
            {1, 0}, 
            {0, -1},
            {0, 1}  
        };

        while (!queue.isEmpty()) {

            int[] curr = queue.poll();

            int r = curr[0];
            int c = curr[1];

            for (int[] dir : directions) {

                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr < 0 || nr >= m ||
                    nc < 0 || nc >= n) {
                    continue;
                }
                if (mat[nr][nc] != -1) {
                    continue;
                }
                mat[nr][nc] = mat[r][c] + 1;

                queue.offer(new int[]{nr, nc});
            }
        }

        return mat;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna