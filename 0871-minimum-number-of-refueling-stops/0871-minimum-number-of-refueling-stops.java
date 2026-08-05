class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> maxHeap =
            new PriorityQueue<>((a, b) -> b - a);

        int fuel = startFuel;
        int stops = 0;
        int previousPosition = 0;

        for (int[] station : stations) {

            int position = station[0];
            int stationFuel = station[1];

            int distance = position - previousPosition;

            fuel -= distance;
            while (fuel < 0 && !maxHeap.isEmpty()) {

                fuel += maxHeap.poll();
                stops++;
            }

            if (fuel < 0) {
                return -1;
            }

            maxHeap.offer(stationFuel);

            previousPosition = position;
        }

        int distanceToTarget = target - previousPosition;

        fuel -= distanceToTarget;

        while (fuel < 0 && !maxHeap.isEmpty()) {

            fuel += maxHeap.poll();
            stops++;
        }

        if (fuel < 0) {
            return -1;
        }

        return stops;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna