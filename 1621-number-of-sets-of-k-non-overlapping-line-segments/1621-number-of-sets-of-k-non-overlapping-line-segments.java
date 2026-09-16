class Solution {

    static final int MOD = 1_000_000_007;

    public int numberOfSets(int n, int k) {
        int N = n + k - 1;

        long[][] dp = new long[N + 1][2 * k + 1];
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= N; i++) {

            for (int j = 1; j <= Math.min(i, 2 * k); j++) {

                dp[i][j] =
                        (dp[i - 1][j - 1] + dp[i - 1][j])
                        % MOD;
            }
        }

        return (int) dp[N][2 * k];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna