class Solution {

    public int combinationSum4(int[] nums, int target) {

        int[] dp = new int[target + 1];

        dp[0] = 1;

        for (int sum = 1; sum <= target; sum++) {

            for (int num : nums) {

                if (sum >= num) {

                    dp[sum] += dp[sum - num];
                }
            }
        }

        return dp[target];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna