class Solution {

    class Pair {
        int node;
        int distance;

        Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        List<List<Pair>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            graph.get(u).add(new Pair(v, w));
            graph.get(v).add(new Pair(u, w));
        }

        int answer = -1;
        int minCount = Integer.MAX_VALUE;

        for (int src = 0; src < n; src++) {

            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);

            PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> a.distance - b.distance
            );

            dist[src] = 0;
            pq.offer(new Pair(src, 0));

            while (!pq.isEmpty()) {

                Pair curr = pq.poll();

                if (curr.distance > dist[curr.node])
                    continue;

                for (Pair next : graph.get(curr.node)) {

                    int newDist = curr.distance + next.distance;

                    if (newDist < dist[next.node]) {

                        dist[next.node] = newDist;
                        pq.offer(new Pair(next.node, newDist));
                    }
                }
            }

            int count = 0;

            for (int city = 0; city < n; city++) {

                if (city != src && dist[city] <= distanceThreshold)
                    count++;
            }

            if (count <= minCount) {
                minCount = count;
                answer = src;
            }
        }

        return answer;
    }
}