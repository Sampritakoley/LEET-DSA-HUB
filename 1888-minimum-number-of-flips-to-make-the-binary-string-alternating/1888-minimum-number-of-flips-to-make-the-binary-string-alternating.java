class Solution {
    public int minFlips(String s) {
        int n = s.length();
        int flip1 = 0;
        int flip2 = 0;
        int ans = Integer.MAX_VALUE;
        for (int right = 0; right < 2 * n; right++) {
            char ch = s.charAt(right % n);
            char expected1 = (right % 2 == 0) ? '0' : '1';
            char expected2 = (right % 2 == 0) ? '1' : '0';
            if (ch != expected1) {
                flip1++;
            }
            if (ch != expected2) {
                flip2++;
            }
            if (right >= n) {
                char removed = s.charAt((right - n) % n);
                char old1 = ((right - n) % 2 == 0) ? '0' : '1';
                char old2 = ((right - n) % 2 == 0) ? '1' : '0';
                if (removed != old1) {
                    flip1--;
                }
                if (removed != old2) {
                    flip2--;
                }
            }
            if (right >= n - 1) {
                ans = Math.min(ans, Math.min(flip1, flip2));
            }
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna