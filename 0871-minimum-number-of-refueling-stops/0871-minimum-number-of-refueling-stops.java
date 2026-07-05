import java.util.*;

class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        int fuel = startFuel;
        int i = 0;
        int stops = 0;

        while (fuel < target) {

            while (i < stations.length && stations[i][0] <= fuel) {
                maxHeap.offer(stations[i][1]);
                i++;
            }

            if (maxHeap.isEmpty())
                return -1;

            fuel += maxHeap.poll();
            stops++;
        }

        return stops;
    }
}