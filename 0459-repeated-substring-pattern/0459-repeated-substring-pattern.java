class Solution {

    public boolean repeatedSubstringPattern(String s) {

        int n = s.length();

        int[] lps = buildLPS(s);

        int longestPrefixSuffix = lps[n - 1];
        if (longestPrefixSuffix == 0) {
            return false;
        }

        int repeatingLength = n - longestPrefixSuffix;

        return n % repeatingLength == 0;
    }

    private int[] buildLPS(String s) {

        int n = s.length();

        int[] lps = new int[n];

        int len = 0;
        int i = 1;

        while (i < n) {

            if (s.charAt(i) == s.charAt(len)) {

                len++;
                lps[i] = len;
                i++;

            } else {

                if (len != 0) {
                    len = lps[len - 1];

                } else {

                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna