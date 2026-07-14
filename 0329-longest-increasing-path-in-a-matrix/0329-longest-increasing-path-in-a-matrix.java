class Solution {

    // 4 possible directions
    private final int[][] DIRS = {
        {1, 0},   // Down
        {-1, 0},  // Up
        {0, 1},   // Right
        {0, -1}   // Left
    };

    private int[][] dp;
    private int m, n;

    public int longestIncreasingPath(int[][] matrix) {

        m = matrix.length;
        n = matrix[0].length;

        dp = new int[m][n];

        int ans = 0;

        // Start DFS from every cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(matrix, i, j));
            }
        }

        return ans;
    }

    private int dfs(int[][] matrix, int row, int col) {

        if (dp[row][col] != 0)
            return dp[row][col];

        int maxLength = 1; 

        for (int[] dir : DIRS) {

            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n)
                continue;

            if (matrix[newRow][newCol] > matrix[row][col]) {
                maxLength = Math.max(maxLength,
                        1 + dfs(matrix, newRow, newCol));
            }
        }

        dp[row][col] = maxLength;

        return maxLength;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna