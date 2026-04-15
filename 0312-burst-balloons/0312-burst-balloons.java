class Solution {
    public int maxCoins(int[] nums) {
        int[][] dp=new int[nums.length][nums.length];
        for(int g=0;g<=nums.length;g++){
            for(int i=0,j=g;j<nums.length;j++,i++){
                for(int k=i;k<=j;k++){
                    int left=(k==i)?0:dp[i][k-1];
                    int right=(k==j)?0:dp[k+1][j];
                    int val=nums[k];
                    if(i>0){
                        val=val*nums[i-1];
                    }
                    if(j!=nums.length-1){
                        val=val*nums[j+1];
                    }
                    dp[i][j]=Math.max(val+left+right,dp[i][j]);
                }
            }
        }
        return dp[0][nums.length-1];
    }
}