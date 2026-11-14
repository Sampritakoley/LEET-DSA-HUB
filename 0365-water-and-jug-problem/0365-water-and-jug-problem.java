class Solution {

    public boolean canMeasureWater(int x, int y, int target) {

        if (target == 0) {
            return true;
        }

        if ((long) target > (long) x + y) {
            return false;
        }

        return target % gcd(x, y) == 0;
    }

    private int gcd(int a, int b) {

        while (b != 0) {

            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna