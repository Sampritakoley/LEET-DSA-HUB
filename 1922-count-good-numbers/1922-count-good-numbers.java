
class Solution {

    private static final long MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {

        long even = (n + 1) / 2;
        long odd = n / 2;

        long first = power(5, even);
        long second = power(4, odd);

        return (int) ((first * second) % MOD);
    }

    private long power(long base, long exponent) {

        long result = 1;

        while (exponent > 0) {

            if (exponent % 2 == 1) {
                result = (result * base) % MOD;
            }

            base = (base * base) % MOD;

            exponent = exponent / 2;
        }

        return result;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna