class Solution {
    public int jump(int[] nums) {

        int n = nums.length;
        int[] dp = new int[n];

        dp[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {

            int min = Integer.MAX_VALUE;

            for (int j = 1; j <= nums[i] && i + j < n; j++) {
                min = Math.min(min, dp[i + j]);
            }

            dp[i] = (min == Integer.MAX_VALUE) ? Integer.MAX_VALUE : min + 1;
        }

        return dp[0];
    }
}