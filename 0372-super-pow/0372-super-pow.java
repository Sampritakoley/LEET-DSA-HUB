
class Solution {

    private static final int MOD = 1337;

    public int superPow(int a, int[] b) {

        a %= MOD;

        int result = 1;

        for (int digit : b) {

            result = (pow(result, 10) * pow(a, digit)) % MOD;
        }

        return result;
    }

    private int pow(int a, int n) {

        int result = 1;

        a %= MOD;

        while (n > 0) {

            if (n % 2 == 1) {
                result = (result * a) % MOD;
            }

            a = (a * a) % MOD;

            n /= 2;
        }

        return result;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna