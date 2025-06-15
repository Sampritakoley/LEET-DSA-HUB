class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        int overallMax=0;
        for(int i=0;i<nums.length;i++){
             int max=0;
             for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    max=dp[j]>max?dp[j]:max;
                }
             }
             dp[i]=max+1;
             overallMax=overallMax<dp[i]?dp[i]:overallMax;
        }
        return overallMax;
    }
}