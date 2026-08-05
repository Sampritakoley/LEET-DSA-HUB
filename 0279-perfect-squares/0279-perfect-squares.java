
class Solution {
    public int numSquares(int n) {

        int[] dp = new int[n + 1];

        Arrays.fill(dp, n);

        dp[0] = 0;

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j * j <= i; j++) {

                int square = j * j;

                dp[i] = Math.min(
                    dp[i],
                    dp[i - square] + 1
                );
            }
        }

        return dp[n];
    }
}



// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna