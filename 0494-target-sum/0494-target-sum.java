class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum=0;
        for(int num:nums){
            totalSum+=num;
        }
        if ((totalSum + target) % 2 != 0 || Math.abs(target) > totalSum) {
    return 0;
}
        int targetSum=(totalSum+target)/2;
        int[] dp=new int[targetSum+1];
        dp[0]=1;
        for(int i=1;i<nums.length+1;i++){
            for(int j=targetSum;j>=nums[i-1];j--){
                if(j>=nums[i-1]){
                    dp[j]+=dp[j-nums[i-1]];
                }
            }
        }
        return dp[targetSum];
    }
}