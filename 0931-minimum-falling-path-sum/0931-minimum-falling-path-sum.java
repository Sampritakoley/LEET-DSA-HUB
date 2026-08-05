
class Solution {
    public int minFallingPathSum(int[][] matrix) {

        int n = matrix.length;

        int[][] dp = new int[n][n];

        for (int col = 0; col < n; col++) {
            dp[0][col] = matrix[0][col];
        }

        for (int row = 1; row < n; row++) {

            for (int col = 0; col < n; col++) {

                int min = dp[row - 1][col];

                if (col > 0) {
                    min = Math.min(min, dp[row - 1][col - 1]);
                }

                if (col < n - 1) {
                    min = Math.min(min, dp[row - 1][col + 1]);
                }

                dp[row][col] = matrix[row][col] + min;
            }
        }

        int answer = Integer.MAX_VALUE;

        for (int col = 0; col < n; col++) {
            answer = Math.min(answer, dp[n - 1][col]);
        }

        return answer;
    }
}



// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna