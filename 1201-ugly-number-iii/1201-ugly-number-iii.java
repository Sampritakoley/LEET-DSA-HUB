
class Solution {

    public int nthUglyNumber(int n, int a, int b, int c) {

        long ab = lcm(a, b);
        long bc = lcm(b, c);
        long ac = lcm(a, c);

        long abc = lcm(ab, c);

        long low = 1;
        long high = 2L * Math.min(a, Math.min(b, c)) * n;

        while (low < high) {

            long mid = low + (high - low) / 2;

            long count =
                    mid / a +
                    mid / b +
                    mid / c -
                    mid / ab -
                    mid / bc -
                    mid / ac +
                    mid / abc;

            if (count >= n) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return (int) low;
    }

    private long gcd(long a, long b) {

        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    private long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna