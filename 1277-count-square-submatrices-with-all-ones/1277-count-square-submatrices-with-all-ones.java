
class Solution {
    public int countSquares(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        int count = 0;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } 
                    else {
                        dp[i][j] = 1 + Math.min(
                            dp[i - 1][j],
                            Math.min(
                                dp[i][j - 1],
                                dp[i - 1][j - 1]
                            )
                        );
                    }

                    count += dp[i][j];
                }
            }
        }

        return count;
    }
}



// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna