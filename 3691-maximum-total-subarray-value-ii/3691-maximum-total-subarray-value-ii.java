
import java.util.*;

class Solution {
    private int[][] maxST;
    private int[][] minST;
    private int[] log;

    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;

        buildSparseTable(nums);
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[0], a[0])
        );
        for (int l = 0; l < n; l++) {
            int value = getValue(l, n - 1);
            maxHeap.offer(new int[]{value, l, n - 1});
        }

        long total = 0;
        for (int i = 0; i < k; i++) {
            int[] current = maxHeap.poll();

            int value = current[0];
            int l = current[1];
            int r = current[2];

            total += value;
            if (r > l) {
                int nextValue = getValue(l, r - 1);
                maxHeap.offer(new int[]{
                    nextValue, l, r - 1
                });
            }
        }

        return total;
    }

    private void buildSparseTable(int[] nums) {
        int n = nums.length;

        log = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            log[i] = log[i / 2] + 1;
        }

        int levels = log[n] + 1;

        maxST = new int[n][levels];
        minST = new int[n][levels];

        for (int i = 0; i < n; i++) {
            maxST[i][0] = nums[i];
            minST[i][0] = nums[i];
        }

        for (int j = 1; j < levels; j++) {
            int len = 1 << j;
            int half = len / 2;

            for (int i = 0; i + len <= n; i++) {
                maxST[i][j] = Math.max(
                    maxST[i][j - 1],
                    maxST[i + half][j - 1]
                );

                minST[i][j] = Math.min(
                    minST[i][j - 1],
                    minST[i + half][j - 1]
                );
            }
        }
    }

    private int getValue(int l, int r) {
        int j = log[r - l + 1];

        int maximum = Math.max(
            maxST[l][j],
            maxST[r - (1 << j) + 1][j]
        );

        int minimum = Math.min(
            minST[l][j],
            minST[r - (1 << j) + 1][j]
        );

        return maximum - minimum;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna