class Solution {

    public int findMaxForm(String[] strs, int m, int n) {

        int[][] dp = new int[m + 1][n + 1];

        for (String s : strs) {

            int zero = 0;
            int one = 0;

            for (char c : s.toCharArray()) {
                if (c == '0')
                    zero++;
                else
                    one++;
            }

            for (int z = m; z >= zero; z--) {

                for (int o = n; o >= one; o--) {

                    dp[z][o] = Math.max(
                            dp[z][o],
                            1 + dp[z - zero][o - one]);
                }
            }
        }

        return dp[m][n];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna