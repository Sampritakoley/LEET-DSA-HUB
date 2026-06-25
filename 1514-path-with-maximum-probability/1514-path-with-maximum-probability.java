class Solution {

    class Pair {
        int node;
        double prob;

        Pair(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }

    public double maxProbability(int n, int[][] edges,
                                 double[] succProb,
                                 int start,
                                 int end) {

        List<List<Pair>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < edges.length; i++) {

            int u = edges[i][0];
            int v = edges[i][1];
            double p = succProb[i];

            graph.get(u).add(new Pair(v, p));
            graph.get(v).add(new Pair(u, p));
        }

        double[] best = new double[n];

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) ->
                        Double.compare(b.prob, a.prob)); 

        best[start] = 1.0;
        pq.offer(new Pair(start, 1.0));

        while (!pq.isEmpty()) {

            Pair curr = pq.poll();

            if (curr.node == end)
                return curr.prob;

            if (curr.prob < best[curr.node])
                continue;

            for (Pair next : graph.get(curr.node)) {

                double newProb = curr.prob * next.prob;

                if (newProb > best[next.node]) {

                    best[next.node] = newProb;
                    pq.offer(new Pair(next.node, newProb));
                }
            }
        }

        return 0.0;
    }
}