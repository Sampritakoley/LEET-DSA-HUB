import java.util.*;

class Solution {

    private String s1;
    private String s2;
    private Integer[][] memo;

    public int minimumDeleteSum(String s1, String s2) {

        this.s1 = s1;
        this.s2 = s2;

        int m = s1.length();
        int n = s2.length();

        memo = new Integer[m][n];

        return solve(0, 0);
    }

    private int solve(int i, int j) {
        if (i == s1.length()) {
            int sum = 0;

            for (int k = j; k < s2.length(); k++) {
                sum += s2.charAt(k);
            }

            return sum;
        }
        if (j == s2.length()) {
            int sum = 0;

            for (int k = i; k < s1.length(); k++) {
                sum += s1.charAt(k);
            }

            return sum;
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {

            return memo[i][j] = solve(i + 1, j + 1);

        } else {

            int deleteFromS1 =
                    s1.charAt(i) + solve(i + 1, j);

            int deleteFromS2 =
                    s2.charAt(j) + solve(i, j + 1);

            return memo[i][j] =
                    Math.min(deleteFromS1, deleteFromS2);
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna