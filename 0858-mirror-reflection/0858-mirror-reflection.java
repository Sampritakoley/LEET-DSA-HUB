
class Solution {

    public int mirrorReflection(int p, int q) {

        int lcm = (p * q) / gcd(p, q);

        int m = lcm / p;
        int n = lcm / q;

        if (m % 2 == 1 && n % 2 == 1) {
            return 1;
        }

        if (m % 2 == 1 && n % 2 == 0) {
            return 2;
        }

        return 0;
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