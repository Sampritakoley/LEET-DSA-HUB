class Solution {
    public int findNthDigit(int n) {

        long count = 9;
        long digits = 1;
        long start = 1;

        while (n > count * digits) {

            n -= count * digits;

            count *= 10;
            start *= 10;
            digits++;
        }

        long q = (n - 1) / digits;
        long rem = (n - 1) % digits;

        long number = start + q;

        return String.valueOf(number).charAt((int) rem) - '0';
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna