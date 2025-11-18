class Solution {
    public class Pair{
        public int node;
        public int time;
        public Pair(int node,int time){
            this.node=node;
            this.time=time;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int[] t : times) {
            int u = t[0];
            int v = t[1];
            int w = t[2];
            graph.get(u).add(new int[]{v, w});
        }
        int[] bestTime = new int[n + 1];
        Arrays.fill(bestTime, Integer.MAX_VALUE);
        bestTime[k] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        pq.offer(new Pair(k, 0));
        while (!pq.isEmpty()){
            Pair p = pq.poll();
            int node = p.node;
            int time = p.time;

            if (time > bestTime[node]) continue;
            for (int[] next : graph.get(node)) {
                int adj = next[0];
                int w = next[1];
                int newTime = time + w;
                if (newTime < bestTime[adj]) {
                    bestTime[adj] = newTime;
                    pq.offer(new Pair(adj, newTime));
                }
            }

        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (bestTime[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, bestTime[i]);
        }
        return ans;
    }
}