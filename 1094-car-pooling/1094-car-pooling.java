
class Solution {

    public boolean carPooling(int[][] trips, int capacity) {

     
        int[] changes = new int[1001];

        for (int[] trip : trips) {

            int passengers = trip[0];
            int from = trip[1];
            int to = trip[2];

            changes[from] += passengers;
            changes[to] -= passengers;
        }

        int currentPassengers = 0;

        for (int location = 0; location <= 1000; location++) {

            currentPassengers += changes[location];

            if (currentPassengers > capacity) {
                return false;
            }
        }

        return true;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna