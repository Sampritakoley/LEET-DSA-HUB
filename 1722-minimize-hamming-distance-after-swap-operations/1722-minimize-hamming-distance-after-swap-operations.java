class Solution {

    int[] parent;
    int[] rank;

    public int minimumHammingDistance(
            int[] source,
            int[] target,
            int[][] allowedSwaps) {

        int n = source.length;

        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int[] swap : allowedSwaps) {
            union(swap[0], swap[1]);
        }

      
        HashMap<Integer, HashMap<Integer, Integer>> graph =
                new HashMap<>();

        for (int i = 0; i < n; i++) {

            int root = findParent(i);

            graph.computeIfAbsent(root,
                    k -> new HashMap<>());

            HashMap<Integer, Integer> map = graph.get(root);
            map.put(source[i],
                    map.getOrDefault(source[i], 0) + 1);
            map.put(target[i],
                    map.getOrDefault(target[i], 0) - 1);
        }

        int answer = 0;
        for (HashMap<Integer, Integer> map : graph.values()) {

            for (int count : map.values()) {

                if (count > 0) {
                    answer += count;
                }
            }
        }

        return answer;
    }

    private int findParent(int u) {

        if (parent[u] != u) {
            parent[u] = findParent(parent[u]);
        }

        return parent[u];
    }

    private void union(int u, int v) {

        int pu = findParent(u);
        int pv = findParent(v);

        if (pu == pv) {
            return;
        }

        if (rank[pu] < rank[pv]) {
            parent[pu] = pv;
        }
        else if (rank[pu] > rank[pv]) {
            parent[pv] = pu;
        }
        else {
            parent[pv] = pu;
            rank[pu]++;
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna