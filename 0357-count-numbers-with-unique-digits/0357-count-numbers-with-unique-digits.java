class Solution {
    public int countNumbersWithUniqueDigits(int n) {

        if (n == 0) {
            return 1;
        }

        int result = 10;
        int unique = 9;
        int available = 9;

        n = Math.min(n, 10);

        for (int i = 2; i <= n; i++) {

            unique = unique * available;

            result += unique;

            available--;
        }

        return result;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna