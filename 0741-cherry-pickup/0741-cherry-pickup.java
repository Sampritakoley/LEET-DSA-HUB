class Solution {

    int[][][] dp;
    int n;

    public int cherryPickup(int[][] grid) {

        n = grid.length;

        dp = new int[n][n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        int ans = solve(0, 0, 0, grid);

        return Math.max(0, ans);
    }

    private int solve(int r1, int c1, int r2, int[][] grid) {

        int c2 = r1 + c1 - r2;

        if (r1 >= n || c1 >= n ||
            r2 >= n || c2 >= n ||
            grid[r1][c1] == -1 ||
            grid[r2][c2] == -1) {

            return Integer.MIN_VALUE;
        }

        if (r1 == n - 1 && c1 == n - 1) {
            return grid[r1][c1];
        }

        if (dp[r1][c1][r2] != -1) {
            return dp[r1][c1][r2];
        }

        int cherries;

        if (r1 == r2 && c1 == c2) {
            cherries = grid[r1][c1];
        } else {
            cherries = grid[r1][c1] + grid[r2][c2];
        }

        int f1 = solve(r1, c1 + 1, r2, grid);      
        int f2 = solve(r1 + 1, c1, r2, grid);       
        int f3 = solve(r1, c1 + 1, r2 + 1, grid);  
        int f4 = solve(r1 + 1, c1, r2 + 1, grid);   

        int best = Math.max(
            Math.max(f1, f2),
            Math.max(f3, f4)
        );

        dp[r1][c1][r2] = cherries + best;

        return dp[r1][c1][r2];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna