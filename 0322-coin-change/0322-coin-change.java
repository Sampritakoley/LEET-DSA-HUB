class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[] dp=new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for(int i=1;i<n+1;i++){
            for(int j=1;j<amount+1;j++){
                if(coins[i-1]<=j){
                    dp[j]=Math.min(dp[j],dp[j-coins[i-1]]+1);
                }
            }
        }
        return dp[amount]>amount?-1:dp[amount];
    }
}