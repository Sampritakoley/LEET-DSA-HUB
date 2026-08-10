
class Solution {

    public int smallestDivisor(int[] nums, int threshold) {

        int low = 1;
        int high = 0;
        for (int num : nums) {
            high = Math.max(high, num);
        }
        while (low < high) {

            int divisor = low + (high - low) / 2;

            long sum = 0;
            for (int num : nums) {

                sum += (num + divisor - 1) / divisor;
            }

            if (sum <= threshold) {
                high = divisor;

            } else {
                low = divisor + 1;
            }
        }

        return low;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna