
import java.util.*;

class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] sorted = new int[n][3];

        for (int i = 0; i < n; i++) {
            sorted[i][0] = tasks[i][0];
            sorted[i][1] = tasks[i][1];
            sorted[i][2] = i;
        }
        Arrays.sort(sorted, (a, b) ->
            Integer.compare(a[0], b[0])
        );
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            }
        );

        int[] order = new int[n];
        int i = 0;
        int completed = 0;
        long time = 0;

        while (completed < n) {
            if (minHeap.isEmpty() && time < sorted[i][0]) {
                time = sorted[i][0];
            }

            while (i < n && sorted[i][0] <= time) {
                minHeap.offer(new int[] {
                    sorted[i][1], sorted[i][2]
                });
                i++;
            }

            int[] task = minHeap.poll();

            order[completed++] = task[1];
            time += task[0];
        }

        return order;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna