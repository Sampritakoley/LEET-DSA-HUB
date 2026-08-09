class Solution {

    public long countPairs(int n, int[][] edges) {

        UnionFind uf = new UnionFind(n);

        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }

        Map<Integer, Integer> componentSize = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            componentSize.put(root, componentSize.getOrDefault(root, 0) + 1);
        }

        long ans = 0;
        long remaining = n;

        for (int size : componentSize.values()) {
            remaining -= size;
            ans += (long) size * remaining;
        }

        return ans;
    }

    class UnionFind {
        int[] parent;
        int[] rank;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px == py)
                return;

            if (rank[px] < rank[py]) {
                parent[px] = py;
            } else if (rank[px] > rank[py]) {
                parent[py] = px;
            } else {
                parent[py] = px;
                rank[px]++;
            }
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna