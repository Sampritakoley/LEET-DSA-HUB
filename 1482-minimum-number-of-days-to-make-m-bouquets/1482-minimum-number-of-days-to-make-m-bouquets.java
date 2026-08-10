
class Solution {

    public int minDays(int[] bloomDay, int m, int k) {

        int n = bloomDay.length;
        if ((long) m * k > n) {
            return -1;
        }

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (int day : bloomDay) {
            low = Math.min(low, day);
            high = Math.max(high, day);
        }
        while (low < high) {

            int mid = low + (high - low) / 2;

            if (canMake(bloomDay, m, k, mid)) {
                high = mid;

            } else {
                low = mid + 1;
            }
        }

        return low;
    }


    private boolean canMake(
        int[] bloomDay,
        int m,
        int k,
        int day
    ) {

        int bouquets = 0;
        int consecutive = 0;

        for (int bloom : bloomDay) {

            if (bloom <= day) {
                consecutive++;
                if (consecutive == k) {

                    bouquets++;
                    consecutive = 0;
                    if (bouquets == m) {
                        return true;
                    }
                }

            } else {

                consecutive = 0;
            }
        }

        return false;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna