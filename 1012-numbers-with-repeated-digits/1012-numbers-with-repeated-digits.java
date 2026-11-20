
class Solution {
    public int numDupDigitsAtMostN(int n) {
        String s = String.valueOf(n);
        int len = s.length();
        int unique = 0;

        for (int i = 1; i < len; i++) {
            int count = 9;

            for (int j = 1; j < i; j++) {
                count *= (10 - j);
            }

            unique += count;
        }
        boolean[] used = new boolean[10];

        for (int i = 0; i < len; i++) {
            int digit = s.charAt(i) - '0';

            for (int d = (i == 0 ? 1 : 0); d < digit; d++) {
                if (!used[d]) {
                    int remaining = len - i - 1;
                    int ways = 1;

                    for (int j = 0; j < remaining; j++) {
                        ways *= (9 - i - j);
                    }

                    unique += ways;
                }
            }

            if (used[digit]) {
                break;
            }

            used[digit] = true;

            if (i == len - 1) {
                unique++;
            }
        }

        return n - unique;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna