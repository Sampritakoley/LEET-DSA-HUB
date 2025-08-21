class Solution {
    public static class Pair {
        int val; 
        long w;  
        public Pair(int val, long w) {
            this.val = val;
            this.w = w;
        }
    }

    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            int u = road[0], v = road[1], w = road[2];
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.w, b.w));
        long[] dist = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        Arrays.fill(ways, 0);

        dist[0] = 0;
        ways[0] = 1;
        pq.add(new Pair(0, 0)); 
        int mod = (int) (1e9 + 7);

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int node = p.val;
            Long dis = p.w;

            if (dis > dist[node]) continue;

            for (Pair nb : adj.get(node)) {
                if (dis + nb.w < dist[nb.val]) {
                    dist[nb.val] = dis + nb.w;
                    pq.add(new Pair(nb.val, dist[nb.val]));
                    ways[nb.val] = ways[node];
                } else if (dis + nb.w == dist[nb.val]) {
                    ways[nb.val] = (ways[nb.val] + ways[node]) % mod;
                }
            }
        }
        return ways[n - 1] % mod;
    }
}
