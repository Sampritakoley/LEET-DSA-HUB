
class Solution {
    public int reachNumber(int target) {

        long t = Math.abs((long) target);

        long sum = 0;
        int steps = 0;

        while (sum < t || (sum - t) % 2 != 0) {

            steps++;

            sum += steps;
        }

        return steps;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna