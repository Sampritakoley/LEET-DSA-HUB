class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {

        long low = 1;
        long minTime = Integer.MAX_VALUE;

        for (int t : workerTimes) {
            minTime = Math.min(minTime, t);
        }

        long high = minTime * mountainHeight *
                    (mountainHeight + 1L) / 2;

        long ans = high;

        while (low <= high) {

            long mid = low + (high - low) / 2;

            if (isPossible(mid, mountainHeight, workerTimes)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean isPossible(long time, int mountainHeight,
                               int[] workerTimes) {

        long total = 0;

        for (int t : workerTimes) {

            long left = 0;
            long right = mountainHeight;

            while (left <= right) {

                long x = left + (right - left) / 2;

                long required = (long) t * x * (x + 1) / 2;

                if (required <= time) {
                    left = x + 1;
                } else {
                    right = x - 1;
                }
            }

            total += left - 1;

            if (total >= mountainHeight) {
                return true;
            }
        }

        return false;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna