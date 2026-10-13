
import java.util.*;

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a, b) ->
            Integer.compare(a[1], b[1])
        );
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        int passengers = 0;

        for (int[] trip : trips) {
            int count = trip[0];
            int start = trip[1];
            int end = trip[2];
            while (!minHeap.isEmpty()
                    && minHeap.peek()[0] <= start) {

                int[] endedTrip = minHeap.poll();
                passengers -= endedTrip[1];
            }
            passengers += count;
            if (passengers > capacity) {
                return false;
            }
            minHeap.offer(new int[]{end, count});
        }

        return true;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna