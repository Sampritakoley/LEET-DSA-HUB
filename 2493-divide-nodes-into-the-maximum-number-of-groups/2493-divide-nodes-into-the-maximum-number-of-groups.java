class Solution {

    public int magnificentSets(int n, int[][] edges) {

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

        int[] level = new int[n + 1];
        int ans=0;
        for (int start = 1; start <= n; start++) {

            if (level[start] != 0) {
                continue;
            }

            Queue<Integer> queue = new LinkedList<>();
            List<Integer> component = new ArrayList<>();


            queue.offer(start);
            level[start] = 1;

            while (!queue.isEmpty()) {

                int current = queue.poll();
                 component.add(current);

                for (int next : graph[current]) {

                    if (level[next] == 0) {

                        level[next] = level[current] + 1;
                        queue.offer(next);

                    } else {
                        if (level[next] == level[current]) {
                            return -1;
                        }
                    }
                }
            }
            
            int maxGroups = 0;

            for (int node : component) {

                int groups = bfs(node, graph);

                maxGroups = Math.max(
                    maxGroups,
                    groups
                );
            }
            ans += maxGroups;
        }
        return ans;
    }

    private int bfs(int start, List<Integer>[] graph) {

        Queue<Integer> queue = new LinkedList<>();

        int[] distance = new int[graph.length];

        queue.offer(start);
        distance[start] = 1;

        int maxLevel = 1;

        while (!queue.isEmpty()) {

            int current = queue.poll();

            for (int next : graph[current]) {

                if (distance[next] == 0) {

                    distance[next] = distance[current] + 1;

                    maxLevel = Math.max(
                        maxLevel,
                        distance[next]
                    );

                    queue.offer(next);
                }
            }
        }

        return maxLevel;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna