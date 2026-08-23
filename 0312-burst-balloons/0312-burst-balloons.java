class Solution {
    public int maxCoins(int[] nums) {

        int n = nums.length;
        int[] arr = new int[n + 2];

        arr[0] = 1;
        arr[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }

        int[][] dp = new int[n + 2][n + 2];
        for (int len = 1; len <= n; len++) {

            for (int i = 1; i <= n - len + 1; i++) {

                int j = i + len - 1;
                for (int k = i; k <= j; k++) {

                    int coins =
                            dp[i][k - 1]
                            + dp[k + 1][j]
                            + arr[i - 1] * arr[k] * arr[j + 1];

                    dp[i][j] = Math.max(dp[i][j], coins);
                }
            }
        }

        return dp[1][n];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna