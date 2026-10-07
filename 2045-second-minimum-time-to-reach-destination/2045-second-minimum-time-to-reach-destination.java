import java.util.*;

class Solution {

    public int secondMinimum(
            int n,
            int[][] edges,
            int time,
            int change) {

        List<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        int[][] dist = new int[n + 1][2];

        for (int i = 1; i <= n; i++) {
            dist[i][0] = Integer.MAX_VALUE;
            dist[i][1] = Integer.MAX_VALUE;
        }

        Queue<int[]> queue = new LinkedList<>();

        dist[1][0] = 0;

        queue.offer(new int[]{1, 0});


        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int node = current[0];
            int distance = current[1];

            for (int next : graph[node]) {

                int newDistance = distance + 1;
                if (newDistance < dist[next][0]) {

                    dist[next][1] = dist[next][0];
                    dist[next][0] = newDistance;

                    queue.offer(new int[]{
                            next,
                            newDistance
                    });
                }
                else if (
                        newDistance > dist[next][0]
                        && newDistance < dist[next][1]
                ) {

                    dist[next][1] = newDistance;

                    queue.offer(new int[]{
                            next,
                            newDistance
                    });
                }
            }
        }

        int secondShortestEdges = dist[n][1];

        int currentTime = 0;

        for (int i = 0; i < secondShortestEdges; i++) {
            if ((currentTime / change) % 2 == 1) {
                currentTime =
                        (currentTime / change + 1) * change;
            }
            currentTime += time;
        }

        return currentTime;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna