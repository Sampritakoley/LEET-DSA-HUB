import java.util.*;

class Solution {

    public int minJumps(int[] arr) {

        int n = arr.length;

        if (n == 1) {
            return 0;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>())
               .add(i);
        }
        int[] dist = new int[n];
        Arrays.fill(dist, -1);

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(0);
        dist[0] = 0;

        while (!queue.isEmpty()) {

            int i = queue.poll();

            int nextDistance = dist[i] + 1;

            if (i + 1 < n && dist[i + 1] == -1) {

                dist[i + 1] = nextDistance;

                if (i + 1 == n - 1) {
                    return dist[i + 1];
                }

                queue.offer(i + 1);
            }
            if (i - 1 >= 0 && dist[i - 1] == -1) {

                dist[i - 1] = nextDistance;

                queue.offer(i - 1);
            }

            List<Integer> sameValueIndices = map.get(arr[i]);

            if (sameValueIndices != null) {

                for (int next : sameValueIndices) {
                   
                    if (dist[next] == -1) {

                        dist[next] = nextDistance;

                        if (next == n - 1) {
                            return dist[next];
                        }

                        queue.offer(next);
                    }
                }
                map.remove(arr[i]);
                
            }
        }

        return -1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna