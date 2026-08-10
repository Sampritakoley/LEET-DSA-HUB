
class Solution {

    public long minimumTime(int[] time, int totalTrips) {

        long low = 1;

        long minTime = Long.MAX_VALUE;

        for (int t : time) {
            minTime = Math.min(minTime, t);
        }
        long high = minTime * totalTrips;

        while (low < high) {

            long mid = low + (high - low) / 2;

            long trips = 0;

            for (int t : time) {

                trips += mid / t;
                
            }

            if (trips >= totalTrips) {
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