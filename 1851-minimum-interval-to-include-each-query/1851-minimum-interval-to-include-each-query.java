import java.util.*;

class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) ->
            Integer.compare(a[0], b[0])
        );
        int n = queries.length;
        int[][] sortedQueries = new int[n][2];

        for (int i = 0; i < n; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        Arrays.sort(sortedQueries, (a, b) ->
            Integer.compare(a[0], b[0])
        );
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        int[] answer = new int[n];
        int i = 0;

        for (int[] query : sortedQueries) {
            int q = query[0];
            int originalIndex = query[1];
            while (i < intervals.length &&
                   intervals[i][0] <= q) {

                int left = intervals[i][0];
                int right = intervals[i][1];
                int size = right - left + 1;

                minHeap.offer(new int[]{size, right});
                i++;
            }
            while (!minHeap.isEmpty() &&
                   minHeap.peek()[1] < q) {
                minHeap.poll();
            }
            if (minHeap.isEmpty()) {
                answer[originalIndex] = -1;
            } else {
                answer[originalIndex] = minHeap.peek()[0];
            }
        }

        return answer;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna