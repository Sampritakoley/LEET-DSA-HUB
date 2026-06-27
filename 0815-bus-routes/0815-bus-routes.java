import java.util.*;

class Solution {

    public int numBusesToDestination(int[][] routes, int source, int target) {

        if (source == target) {
            return 0;
        }

        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        buildMap(routes, map);

        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visitedBus = new HashSet<>();
        HashSet<Integer> visitedStops = new HashSet<>();

        q.offer(source);
        visitedStops.add(source);

        int buses = 0;

        while (!q.isEmpty()) {

            int size = q.size();
            buses++; 

            while (size-- > 0) {

                int stop = q.poll();

                if (!map.containsKey(stop))
                    continue;

                for (int bus : map.get(stop)) {

                    if (visitedBus.contains(bus))
                        continue;

                    visitedBus.add(bus);

                    for (int nextStop : routes[bus]) {

                        if (nextStop == target)
                            return buses;

                        if (visitedStops.add(nextStop)) {
                            q.offer(nextStop);
                        }
                    }
                }
            }
        }

        return -1;
    }

    public void buildMap(int[][] routes, HashMap<Integer, HashSet<Integer>> map) {

        for (int bus = 0; bus < routes.length; bus++) {

            for (int stop : routes[bus]) {

                map.computeIfAbsent(stop, k -> new HashSet<>()).add(bus);
            }
        }
    }
}