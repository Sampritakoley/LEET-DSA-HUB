class Solution {
    int[] dp;
    int MOD = 1000000007;

    public int numberOfArrays(String s, int k) {
        dp = new int[s.length()];
        Arrays.fill(dp, -1);

        return help(s, 0, k);
    }

    private int help(String s, int i, int k) {

        if (i == s.length()) {
            return 1;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        if (s.charAt(i) == '0') {
            return 0;
        }

        long num = 0;
        int ans = 0;

        for (int j = i; j < s.length(); j++) {

            num = num * 10 + (s.charAt(j) - '0');

            if (num > k) {
                break;
            }

            ans = (ans + help(s, j + 1, k)) % MOD;
        }

        return dp[i] = ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna