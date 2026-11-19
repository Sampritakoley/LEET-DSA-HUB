class Solution {

    public int findKthNumber(int n, int k) {

        int current = 1;
        k--;

        while (k > 0) {

            int steps = count(current, n);

            if (steps <= k) {

                current++;
                k -= steps;

            } else {

                current *= 10;
                k--;
            }
        }

        return current;
    }

    private int count(long current, long n) {

        long next = current + 1;
        long count = 0;

        while (current <= n) {

            count += Math.min(n + 1, next) - current;

            current *= 10;
            next *= 10;
        }

        return (int) count;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna