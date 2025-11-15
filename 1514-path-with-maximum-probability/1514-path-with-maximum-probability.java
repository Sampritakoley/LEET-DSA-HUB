class Solution {
    class Pair {
        int node;
        double prob;

        Pair(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double p = succProb[i];

            graph.get(u).add(new Pair(v, p));
            graph.get(v).add(new Pair(u, p));
        }
        double[] maxProb = new double[n];
        Arrays.fill(maxProb, -1.0);
        maxProb[start_node] = 1.0;
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> Double.compare(b.prob, a.prob)   // highest probability first
        );

        pq.offer(new Pair(start_node, 1.0));
        while (!pq.isEmpty()){
            Pair curr = pq.poll();

            int node = curr.node;
            double prob = curr.prob;

            if (node == end_node) {
                return prob;
            }

            if (prob < maxProb[node]) continue;

            for (Pair nei : graph.get(node)) {
                double newProb = prob * nei.prob;

                if (newProb > maxProb[nei.node]) {
                    maxProb[nei.node] = newProb;
                    pq.offer(new Pair(nei.node, newProb));
                }
            }
        }

        return 0.0;

    }
}