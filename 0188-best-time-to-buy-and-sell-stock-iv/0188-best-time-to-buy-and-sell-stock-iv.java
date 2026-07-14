class Solution {

    public int maxProfit(int k, int[] prices) {

        int n = prices.length;

        if (n == 0)
            return 0;

        int[][] dp = new int[k + 1][n];

        for (int t = 1; t <= k; t++) {

            for (int d = 1; d < n; d++) {

                int max = dp[t][d - 1];

                for (int m = 0; m < d; m++) {

                    max = Math.max(max,
                            dp[t - 1][m] + prices[d] - prices[m]);
                }

                dp[t][d] = max;
            }
        }

        return dp[k][n - 1];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna