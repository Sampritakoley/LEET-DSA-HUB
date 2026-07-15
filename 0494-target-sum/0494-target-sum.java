class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        int total = 0;
        for (int num : nums)
            total += num;
        if (Math.abs(target) > total)
            return 0;

        if ((total + target) % 2 != 0)
            return 0;

        int sum = (total + target) / 2;
        int n = nums.length;

        int[][] dp = new int[n + 1][sum + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {

            int num = nums[i - 1];

            for (int j = 0; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= num) {
                    dp[i][j] += dp[i - 1][j - num];
                }
            }
        }

        return dp[n][sum];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna