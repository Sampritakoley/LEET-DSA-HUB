class Solution {

    public int maxAreaOfIsland(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int maxArea = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                if (grid[row][col] == 1) {

                    int currentArea = dfs(grid, row, col);

                    maxArea = Math.max(maxArea, currentArea);
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int row, int col) {

        if (row < 0 || row >= grid.length ||
            col < 0 || col >= grid[0].length) {
            return 0;
        }

        if (grid[row][col] == 0) {
            return 0;
        }

        grid[row][col] = 0;

        int area = 1;

        area += dfs(grid, row - 1, col); 
        area += dfs(grid, row + 1, col); 
        area += dfs(grid, row, col - 1); 
        area += dfs(grid, row, col + 1);

        return area;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna