class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp=new int[nums.length];
        if(nums.length==1){
            return 1;
        }
        dp[0]=1;int max=Integer.MIN_VALUE;
        for(int i=1;i<n;i++){
            dp[i]=1;
            for(int j=i-1;j>=0;j--){
                if(nums[j]<nums[i]){
                   dp[i]=Math.max(dp[j]+1,dp[i]);
                }
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}