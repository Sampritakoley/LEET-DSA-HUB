class Solution {
    public int findTargetSumWays(int[] nums, int target) {
            int totalSum = 0;
        for (int num : nums) totalSum += num;
        if (Math.abs(target) > totalSum || (totalSum + target) % 2 != 0) {
            return 0;
        }

        int sum = (totalSum + target) / 2;

        int[] dp = new int[sum + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int j = sum; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[sum];
    }
}