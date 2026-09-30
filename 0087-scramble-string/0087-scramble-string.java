class Solution {

    private Boolean[][][] memo;

    public boolean isScramble(String s1, String s2) {

        int n = s1.length();

        if (n != s2.length()) {
            return false;
        }

        memo = new Boolean[n][n][n + 1];

        return solve(s1, s2, 0, 0, n);
    }

    private boolean solve(
            String s1,
            String s2,
            int i,
            int j,
            int len) {
        if (memo[i][j][len] != null) {
            return memo[i][j][len];
        }
        if (s1.substring(i, i + len)
             .equals(s2.substring(j, j + len))) {

            return memo[i][j][len] = true;
        }
        if (len == 1) {
            return memo[i][j][len] = false;
        }
        for (int k = 1; k < len; k++) {
            boolean noSwap =solve(s1, s2,i,j,k)&&solve(s1, s2,i + k,j + k,len - k);

            if (noSwap) {
                return memo[i][j][len] = true;
            }
            boolean swap =
                    solve(s1, s2,
                          i,
                          j + len - k,
                          k)
                    &&
                    solve(s1, s2,
                          i + k,
                          j,
                          len - k);

            if (swap) {
                return memo[i][j][len] = true;
            }
        }

        return memo[i][j][len] = false;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna