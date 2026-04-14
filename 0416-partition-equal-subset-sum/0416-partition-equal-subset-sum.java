class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum=0;
        for(int n:nums){
            totalSum+=n;
        }
        if(totalSum%2!=0){
            return false;
        }
        int targetSum=totalSum/2;
        boolean[] dp=new boolean[targetSum+1];
        dp[0]=true;
        for(int i=1;i<nums.length+1;i++){
            for(int j=targetSum;j>=i;j--){
                if(nums[i-1]<=j){
                    dp[j]=(dp[j] || dp[j-nums[i-1]]);
                }
            }
        }
        return dp[targetSum];
    }
}