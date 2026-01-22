class Solution {
    public int minFallingPathSum(int[][] matrix) {
           int n = matrix.length;
    int[] dp = new int[n];

    for (int j = 0; j < n; j++) {
        dp[j] = matrix[0][j];
    }

    for (int i = 1; i < n; i++) {
        int[] newDp = new int[n];
        for (int j = 0; j < n; j++) {
            int min = dp[j];

            if (j > 0) min = Math.min(min, dp[j - 1]);
            if (j < n - 1) min = Math.min(min, dp[j + 1]);

            newDp[j] = matrix[i][j] + min;
        }
        dp = newDp;
    }

    int ans = Integer.MAX_VALUE;
    for (int val : dp) ans = Math.min(ans, val);

    return ans;
    }
}