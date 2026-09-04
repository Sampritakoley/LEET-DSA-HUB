class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        boolean s1Breaks = true;
        boolean s2Breaks = true;

        for (int i = 0; i < a.length; i++) {
            if (a[i] < b[i]) {
                s1Breaks = false;
            }

            if (b[i] < a[i]) {
                s2Breaks = false;
            }
        }

        return s1Breaks || s2Breaks;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna