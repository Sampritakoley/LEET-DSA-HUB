class Solution {

    public int lastStoneWeightII(int[] stones) {

        int sum = 0;

        for (int x : stones)
            sum += x;

        int target = sum / 2;

        int[] dp = new int[target + 1];

        for (int stone : stones) {

            for (int t = target; t >= stone; t--) {

                dp[t] = Math.max(
                        dp[t],
                        stone + dp[t - stone]);
            }
        }

        return sum - 2 * dp[target];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna