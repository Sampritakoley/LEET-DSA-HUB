
class Solution {
    public int countDigitOne(int n) {

        int ans = 0;

        for (long i = 1; i <= n; i *= 10) {

            long div = i * 10;

            long q = n / div;
            long rem = n % div;
            ans += q * i;
            if (rem >= i) {
                ans += Math.min(rem - i + 1, i);
            }
        }

        return ans;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna