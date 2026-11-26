import java.util.*;

class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        int[] sorted = new int[n];
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            sorted[i] = arr[i][0];
            pos[arr[i][1]] = i;
        }
        int[] next = new int[n];
        int j = 0;
        for (int i = 0; i < n; i++) {

            j = Math.max(j, i);

            while (j + 1 < n &&
                   (long) sorted[j + 1] - sorted[i] <= maxDiff) {
                j++;
            }

            next[i] = j;
        }
        int LOG = 1;

        while ((1 << LOG) <= n) {
            LOG++;
        }

        int[][] up = new int[LOG][n];

        for (int i = 0; i < n; i++) {
            up[0][i] = next[i];
        }

        for (int k = 1; k < LOG; k++) {
            for (int i = 0; i < n; i++) {
                up[k][i] = up[k - 1][up[k - 1][i]];
            }
        }
        int[] ans = new int[queries.length];
        for (int q = 0; q < queries.length; q++) {

            int u = pos[queries[q][0]];
            int v = pos[queries[q][1]];

            if (u == v) {
                ans[q] = 0;
                continue;
            }

            if (u > v) {
                int temp = u;
                u = v;
                v = temp;
            }

            int steps = 0;

            for (int k = LOG - 1; k >= 0; k--) {

                if (up[k][u] < v) {
                    u = up[k][u];
                    steps += (1 << k);
                }
            }

            if (next[u] >= v) {
                ans[q] = steps + 1;
            } else {
                ans[q] = -1;
            }
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna