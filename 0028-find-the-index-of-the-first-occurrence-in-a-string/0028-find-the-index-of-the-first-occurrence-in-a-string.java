class Solution {

    public int strStr(String haystack, String needle) {

        if (needle.length() == 0) {
            return 0;
        }

        int[] lps = buildLPS(needle);

        int i = 0; 
        int j = 0; 

        while (i < haystack.length()) {

            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;

                if (j == needle.length()) {
                    return i - j;
                }

            } else {
                if (j != 0) {
                    j = lps[j - 1];

                } else {
                    i++;
                }
            }
        }

        return -1;
    }

    private int[] buildLPS(String pattern) {

        int n = pattern.length();
        int[] lps = new int[n];

        int len = 0;
        int i = 1;

        while (i < n) {

            if (pattern.charAt(i) == pattern.charAt(len)) {

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