
class Solution {

    private static final long MOD = 1_000_000_007L;

    public int nthMagicalNumber(int n, int a, int b) {

        long lcm = (long) a / gcd(a, b) * b;

        long low = 1;
        long high = (long) n * Math.min(a, b);

        while (low < high) {

            long mid = low + (high - low) / 2;

            long count = mid / a
                       + mid / b
                       - mid / lcm;

            if (count >= n) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return (int) (low % MOD);
    }

    private long gcd(long a, long b) {

        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna