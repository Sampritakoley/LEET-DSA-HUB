class Solution {
    public boolean canPartition(int[] nums) {
       int totalSum=0;
       for(int val:nums){
        totalSum+=val;
       }
       if(totalSum%2!=0){
        return false;
       }

       int targetSum=totalSum/2;

       boolean[][] dp=new boolean[nums.length+1][targetSum+1];
       for(int i=0;i<dp.length;i++){
            dp[i][0]=true;
       }
     

       for(int i=1;i<dp.length;i++){
          for(int j=1;j<dp[0].length;j++){
            dp[i][j]=dp[i-1][j];
            if(j>=nums[i-1]){
                dp[i][j]=dp[i][j] || dp[i-1][j-nums[i-1]];
            }
          }
       }
       return dp[nums.length][targetSum];
    }
}