class Solution {

    public long[] resultArray(int[] nums, int k) {

        long[] result = new long[k];
        long[] dp = new long[k];

        for (int num : nums) {

            long[] newDp = new long[k];
            int remainder = num % k;

            newDp[remainder]++;
            for (int r = 0; r < k; r++) {

                if (dp[r] == 0) {
                    continue;
                }

                int newRemainder =
                        (int) ((long) r * remainder % k);

                newDp[newRemainder] += dp[r];
            }
            for (int r = 0; r < k; r++) {
                result[r] += newDp[r];
            }

            dp = newDp;
        }

        return result;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna