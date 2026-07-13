class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        dp[0]=1;int max=1;
        for(int i=1;i<n;i++){
            int j=i-1; dp[i]=1;
            while(j>=0){
               if(nums[j]<nums[i]){
                  dp[i]=dp[j]+1>dp[i]?dp[j]+1:dp[i];
               }
               j--;
            }
            max=max<dp[i]?dp[i]:max;
        }
        return max;
    }
}