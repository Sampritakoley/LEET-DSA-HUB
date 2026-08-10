
class Solution {

    public int minSpeedOnTime(int[] dist, double hour) {

        int low = 1;
        int high = 10_000_000;
        if (!canArrive(dist, high, hour)) {
            return -1;
        }
        while (low < high) {

            int speed = low + (high - low) / 2;

            if (canArrive(dist, speed, hour)) {
                high = speed;

            } else {
                low = speed + 1;
            }
        }

        return low;
    }

    private boolean canArrive(int[] dist, int speed, double hour) {

        double totalTime = 0;
        for (int i = 0; i < dist.length - 1; i++) {

            totalTime += (dist[i] + speed - 1) / speed;

            if (totalTime > hour) {
                return false;
            }
        }
        totalTime += (double) dist[dist.length - 1] / speed;

        return totalTime <= hour;
    }
}



// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna