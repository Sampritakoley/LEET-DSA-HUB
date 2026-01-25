class Solution {
    public int coinChange(int[] coins, int amount) {
         int INF = amount + 1;
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = INF;
        }
        dp[0] = 0;
        for (int coin : coins) {
            for (int a = coin; a <= amount; a++) {
                dp[a] = Math.min(dp[a], 1 + dp[a - coin]);
            }
        }

        return dp[amount] == INF ? -1 : dp[amount];
    }
}