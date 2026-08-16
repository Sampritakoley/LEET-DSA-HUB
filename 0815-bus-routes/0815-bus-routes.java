import java.util.*;

class Solution {

    public int numBusesToDestination(
            int[][] routes,
            int source,
            int target) {
        if (source == target) {
            return 0;
        }

        Map<Integer, List<Integer>> stopToBuses =
                new HashMap<>();
        for (int bus = 0; bus < routes.length; bus++) {

            for (int stop : routes[bus]) {

                stopToBuses
                    .computeIfAbsent(
                        stop,
                        k -> new ArrayList<>()
                    )
                    .add(bus);
            }
        }

        Queue<Integer> queue =
                new LinkedList<>();

        queue.offer(source);
        Set<Integer> visitedStops =
                new HashSet<>();

        visitedStops.add(source);
        boolean[] visitedBus =
                new boolean[routes.length];

        int busesTaken = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();
            busesTaken++;

            for (int i = 0; i < size; i++) {

                int currentStop = queue.poll();
                List<Integer> buses =
                        stopToBuses.get(currentStop);

                if (buses == null) {
                    continue;
                }

                for (int bus : buses) {
                    if (visitedBus[bus]) {
                        continue;
                    }

                    visitedBus[bus] = true;
                    for (int nextStop : routes[bus]) {

                        if (nextStop == target) {
                            return busesTaken;
                        }

                        if (visitedStops.add(nextStop)) {
                            queue.offer(nextStop);
                        }
                    }
                }
            }
        }

        return -1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna