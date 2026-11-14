
class Solution {

    public String smallestGoodBase(String n) {

        long num = Long.parseLong(n);
        for (int m = 60; m >= 1; m--) {

            long low = 2;
            long high = num - 1;

            while (low <= high) {

                long mid = low + (high - low) / 2;

                int comparison = compare(mid, m, num);

                if (comparison == 0) {
                    return String.valueOf(mid);
                } 
                else if (comparison < 0) {
                    low = mid + 1;
                } 
                else {
                    high = mid - 1;
                }
            }
        }
        return String.valueOf(num - 1);
    }
    private int compare(long k, int m, long n) {

        long sum = 1;
        long term = 1;

        for (int i = 1; i <= m; i++) {
            if (term > n / k) {
                return 1;
            }

            term *= k;
            if (sum > n - term) {
                return 1;
            }

            sum += term;
        }

        return Long.compare(sum, n);
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna