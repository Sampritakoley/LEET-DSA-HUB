
import java.util.*;

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );
        for (int row = 0; row < n; row++) {
            minHeap.offer(new int[]{matrix[row][0], row, 0});
        }
        for (int count = 1; count <= k; count++) {
            int[] current = minHeap.poll();

            int value = current[0];
            int row = current[1];
            int col = current[2];
            if (count == k) {
                return value;
            }
            if (col + 1 < n) {
                minHeap.offer(
                    new int[]{matrix[row][col + 1], row, col + 1}
                );
            }
        }

        return -1;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna