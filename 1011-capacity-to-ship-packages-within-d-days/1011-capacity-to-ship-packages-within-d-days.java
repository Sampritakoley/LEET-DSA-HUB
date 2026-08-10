
class Solution {

    public int shipWithinDays(int[] weights, int days) {

        int low = 0;
        int high = 0;

        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }
        while (low < high) {

            int capacity = low + (high - low) / 2;

            int daysUsed = 1;
            int currentWeight = 0;
            for (int weight : weights) {

                if (currentWeight + weight > capacity) {
                    daysUsed++;
                    currentWeight = weight;

                } else {

                    currentWeight += weight;
                }
            }

            if (daysUsed <= days) {
                high = capacity;

            } else {
                low = capacity + 1;
            }
        }

        return low;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna