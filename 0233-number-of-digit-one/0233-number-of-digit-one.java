
class Solution {

    public int countDigitOne(int n) {

        long count = 0;

        for (long factor = 1; factor <= n; factor *= 10) {

            long high = n / (factor * 10);

            long current = (n / factor) % 10;

            long low = n % factor;

            if (current == 0) {

                count += high * factor;

            } else if (current == 1) {

                count += high * factor + low + 1;

            } else {

                count += (high + 1) * factor;
            }
        }

        return (int) count;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna