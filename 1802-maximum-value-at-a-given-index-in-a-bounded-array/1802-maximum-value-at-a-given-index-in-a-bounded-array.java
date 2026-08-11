
class Solution {

    public int maxValue(int n, int index, int maxSum) {

        long low = 1;
        long high = maxSum;

        while (low <= high) {

            long mid = low + (high - low) / 2;

            long leftSum = sideSum(mid, index);

            long rightSum = sideSum(mid, n - index - 1);

            long totalSum = leftSum + mid + rightSum;

            if (totalSum <= maxSum) {
                low = mid + 1;

            } else {
                high = mid - 1;
            }
        }

        return (int) high;
    }

    private long sideSum(long x, long length) {
        if (length >= x - 1) {
            long decreasingSum = x * (x - 1) / 2;
            long remaining = length - (x - 1);

            return decreasingSum + remaining;

        } else {
            long first = x - 1;
            long last = x - length;

            return (first + last) * length / 2;
        }
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna