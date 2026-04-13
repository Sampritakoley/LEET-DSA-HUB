class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[] dp=new int[amount+1];
        for(int i=1;i<n+1;i++){
            dp[0]=1;
            for(int j=1;j<amount+1;j++){
                if(j>=coins[i-1]){
                    dp[j]=dp[j]+dp[j-coins[i-1]];
                }
            }
        }
        return dp[amount];
    }
}