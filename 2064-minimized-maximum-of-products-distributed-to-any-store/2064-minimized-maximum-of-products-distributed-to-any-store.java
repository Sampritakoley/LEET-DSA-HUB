class Solution {

    public int minimizedMaximum(int n, int[] quantities) {

        int low = 1;
        int high = 0;
        for (int quantity : quantities) {
            high = Math.max(high, quantity);
        }
        while (low < high) {

            int mid = low + (high - low) / 2;

            long storesRequired = 0;
            for (int quantity : quantities) {

                storesRequired += (quantity + mid - 1) / mid;
                if (storesRequired > n) {
                    break;
                }
            }

            if (storesRequired <= n) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna