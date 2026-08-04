class Solution {

    public int superEggDrop(int eggs, int floors) {

        int[][] dp = new int[eggs + 1][floors + 1];

        for (int e = 1; e <= eggs; e++) {
            dp[e][0] = 0;
            if (floors >= 1) {
                dp[e][1] = 1;
            }
        }

        for (int f = 0; f <= floors; f++) {
            dp[1][f] = f;
        }

        for (int e = 2; e <= eggs; e++) {

            for (int f = 2; f <= floors; f++) {

                int lo = 1;
                int hi = f;

                while (lo <= hi) {

                    int mid = lo + (hi - lo) / 2;

                    int breaks = dp[e - 1][mid - 1];

                    int survives = dp[e][f - mid];

                    if (breaks < survives) {

                        lo = mid + 1;
                    } else {

                        hi = mid - 1;
                    }
                }

                int breaks1 = dp[e - 1][lo - 1];
                int survives1 = dp[e][f - lo];

                int option1 = 1 + Math.max(breaks1, survives1);

                int breaks2 = dp[e - 1][hi - 1];
                int survives2 = dp[e][f - hi];

                int option2 = 1 + Math.max(breaks2, survives2);

                dp[e][f] = Math.min(option1, option2);
            }
        }

        return dp[eggs][floors];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna