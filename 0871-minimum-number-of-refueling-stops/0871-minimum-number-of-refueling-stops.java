
import java.util.*;

class Solution {
    public int minRefuelStops(int target, int startFuel,
                              int[][] stations) {

        PriorityQueue<Integer> maxHeap =
            new PriorityQueue<>(Collections.reverseOrder());

        int maxReach = startFuel;
        int stops = 0;
        int i = 0;

        while (maxReach < target) {

            while (i < stations.length &&
                   stations[i][0] <= maxReach) {
                maxHeap.offer(stations[i][1]);
                i++;
            }

            if (maxHeap.isEmpty()) {
                return -1;
            }

            maxReach += maxHeap.poll();
            stops++;
        }

        return stops;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna