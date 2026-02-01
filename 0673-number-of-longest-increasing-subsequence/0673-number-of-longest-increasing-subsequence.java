class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        int[] cnt=new int [nums.length];
        dp[0]=1;cnt[0]=1;
        int oMax=1;
        for(int i=1;i<nums.length;i++){
           int max=0;cnt[i]=1;
           for(int j=0;j<i;j++){
              if(nums[i]>nums[j]){
                if(max<dp[j]){
                   max=dp[j];
                   cnt[i]=cnt[j];
                }else if(max==dp[j]){
                    cnt[i]+=cnt[j];
                }
              }
           }
           dp[i]=max+1;
           if(dp[i]>oMax){
            oMax=dp[i];
           }
        }

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] == oMax) {
                ans += cnt[i];
            }
        }

        return ans;
        
    }
}