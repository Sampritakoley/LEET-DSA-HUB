import java.util.*;

class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) ->
            Integer.compare(a[0], b[0])
        );
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int n = events.length;
        int i = 0;
        int day = 1;
        int attended = 0;

        while (i < n || !minHeap.isEmpty()) {
            while (i < n && events[i][0] <= day) {
                minHeap.offer(events[i][1]);
                i++;
            }
            while (!minHeap.isEmpty() &&
                   minHeap.peek() < day) {
                minHeap.poll();
            }
            if (!minHeap.isEmpty()) {
                minHeap.poll();
                attended++;
            }

            day++;
        }

        return attended;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna