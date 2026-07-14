class Solution {

    private static final int MOD = 1_000_000_007;
    private int[][] dp;
    private int maxIndex;

    public int numWays(int steps, int arrLen) {

        maxIndex = Math.min(arrLen, steps + 1);

        dp = new int[maxIndex][steps + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return dfs(0, steps);
    }

    private int dfs(int index, int stepsLeft) {

        if (index < 0 || index >= maxIndex) {
            return 0;
        }

        if (stepsLeft == 0) {
            return index == 0 ? 1 : 0;
        }

        if (dp[index][stepsLeft] != -1) {
            return dp[index][stepsLeft];
        }

        long ways = 0;

        ways += dfs(index - 1, stepsLeft - 1);

        ways += dfs(index, stepsLeft - 1);

        ways += dfs(index + 1, stepsLeft - 1);

        dp[index][stepsLeft] = (int) (ways % MOD);

        return dp[index][stepsLeft];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna