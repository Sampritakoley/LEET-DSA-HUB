class Solution {

    public int islandPerimeter(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int perimeter = 0;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] != 1) {
                    continue;
                }

                for (int k = 0; k < 4; k++) {

                    int nr = i + dx[k];
                    int nc = j + dy[k];
                    if (nr < 0 || nr >= rows ||
                        nc < 0 || nc >= cols) {

                        perimeter++;
                    }
                    else if (grid[nr][nc] == 0) {
                        perimeter++;
                    }
                }
            }
        }

        return perimeter;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna