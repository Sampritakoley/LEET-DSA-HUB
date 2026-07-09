class Solution {

    Boolean[][] dp;

    public boolean canPartition(int[] nums) {

        int sum = 0;

        for (int x : nums)
            sum += x;

        if (sum % 2 == 1)
            return false;

        int target = sum / 2;

        dp = new Boolean[nums.length][target + 1];

        return solve(0, target, nums);
    }

    boolean solve(int i, int target, int[] nums) {

        if (target == 0)
            return true;

        if (i == nums.length)
            return false;

        if (dp[i][target] != null)
            return dp[i][target];

        boolean take = false;

        if (nums[i] <= target)
            take = solve(i + 1, target - nums[i], nums);

        boolean skip = solve(i + 1, target, nums);

        return dp[i][target] = take || skip;
    }
}