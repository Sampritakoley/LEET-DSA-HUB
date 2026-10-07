import java.util.*;

class Solution {

    static class State {
        int node;
        int mask;

        State(int node, int mask) {
            this.node = node;
            this.mask = mask;
        }
    }

    public int shortestPathLength(int[][] graph) {

        int n = graph.length;

        int allVisited = (1 << n) - 1;
        boolean[][] visited = new boolean[n][1 << n];

        Queue<State> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {

            int mask = 1 << i;

            queue.offer(new State(i, mask));

            visited[i][mask] = true;
        }

        int distance = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                State current = queue.poll();

                int node = current.node;
                int mask = current.mask;
                if (mask == allVisited) {
                    return distance;
                }

                for (int next : graph[node]) {

                    int newMask =
                            mask | (1 << next);

                    if (!visited[next][newMask]) {

                        visited[next][newMask] = true;

                        queue.offer(
                                new State(next, newMask)
                        );
                    }
                }
            }

            distance++;
        }

        return -1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna