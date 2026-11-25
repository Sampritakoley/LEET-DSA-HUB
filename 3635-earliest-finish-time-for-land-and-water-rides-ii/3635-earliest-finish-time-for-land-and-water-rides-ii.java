
import java.util.*;

class Solution {

    private long solve(
        int[] aStart, int[] aDuration,
        int[] bStart, int[] bDuration
    ) {

        int n = aStart.length;
        int m = bStart.length;

        int[][] first = new int[n][2];
        int[][] second = new int[m][2];

        for (int i = 0; i < n; i++) {
            first[i][0] = aStart[i] + aDuration[i];
            first[i][1] = aStart[i];
        }

        for (int i = 0; i < m; i++) {
            second[i][0] = bStart[i];
            second[i][1] = bDuration[i];
        }

        Arrays.sort(first, (x, y) ->
            Integer.compare(x[0], y[0]));

        Arrays.sort(second, (x, y) ->
            Integer.compare(x[0], y[0]));

        long[] suffix = new long[m];

        suffix[m - 1] =
            (long) second[m - 1][0] + second[m - 1][1];

        for (int i = m - 2; i >= 0; i--) {
            suffix[i] = Math.min(
                suffix[i + 1],
                (long) second[i][0] + second[i][1]
            );
        }

        long ans = Long.MAX_VALUE;
        int j = 0;
        int minDuration = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            long finish = first[i][0];

            while (j < m && second[j][0] <= finish) {
                minDuration = Math.min(
                    minDuration,
                    second[j][1]
                );
                j++;
            }

            if (minDuration != Integer.MAX_VALUE) {
                ans = Math.min(
                    ans,
                    finish + minDuration
                );
            }

            if (j < m) {
                ans = Math.min(ans, suffix[j]);
            }
        }

        return ans;
    }

    public int earliestFinishTime(
        int[] landStartTime,
        int[] landDuration,
        int[] waterStartTime,
        int[] waterDuration
    ) {

        long landFirst = solve(
            landStartTime, landDuration,
            waterStartTime, waterDuration
        );

        long waterFirst = solve(
            waterStartTime, waterDuration,
            landStartTime, landDuration
        );

        return (int) Math.min(landFirst, waterFirst);
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna