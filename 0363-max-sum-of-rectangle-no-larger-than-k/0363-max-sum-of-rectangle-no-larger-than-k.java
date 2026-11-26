
import java.util.*;

class Solution {

    public int maxSumSubmatrix(int[][] matrix, int k) {

        int m = matrix.length;
        int n = matrix[0].length;

        int ans = Integer.MIN_VALUE;
        if (m <= n) {
            for (int top = 0; top < m; top++) {

                int[] sum = new int[n];

                for (int bottom = top; bottom < m; bottom++) {
                    for (int col = 0; col < n; col++) {
                        sum[col] += matrix[bottom][col];
                    }

                    ans = Math.max(
                        ans,
                        maxSubarrayNoLargerThanK(sum, k)
                    );

                    if (ans == k) return k;
                }
            }

        } else {
            for (int left = 0; left < n; left++) {

                int[] sum = new int[m];

                for (int right = left; right < n; right++) {
                    for (int row = 0; row < m; row++) {
                        sum[row] += matrix[row][right];
                    }

                    ans = Math.max(
                        ans,
                        maxSubarrayNoLargerThanK(sum, k)
                    );

                    if (ans == k) return k;
                }
            }
        }

        return ans;
    }

    private int maxSubarrayNoLargerThanK(
        int[] arr, int k
    ) {

        TreeSet<Integer> set = new TreeSet<>();

        set.add(0);

        int prefix = 0;
        int best = Integer.MIN_VALUE;

        for (int num : arr) {

            prefix += num;
            Integer prev = set.ceiling(prefix - k);

            if (prev != null) {
                best = Math.max(best, prefix - prev);
            }

            set.add(prefix);

            if (best == k) {
                return k;
            }
        }

        return best;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna