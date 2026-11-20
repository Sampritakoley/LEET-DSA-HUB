class Solution {
    static final int MOD = 1_000_000_007;
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;
        for (int dice = 1; dice <= n; dice++) {
            for (int sum = 1; sum <= target; sum++) {
                for (int face = 1; face <= k; face++) {
                    if (sum - face >= 0) {
                        dp[dice][sum] =(int) ((dp[dice][sum]+ (long) dp[dice - 1][sum - face])% MOD);
                    }
                }
            }
        }
        return dp[n][target];
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna