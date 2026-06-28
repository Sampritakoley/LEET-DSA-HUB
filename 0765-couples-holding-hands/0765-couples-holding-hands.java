class Solution {

    public int minSwapsCouples(int[] row) {

        int couples = row.length / 2;
        UnionFind uf = new UnionFind(couples);

        for (int i = 0; i < row.length; i += 2) {
            int c1 = row[i] / 2;
            int c2 = row[i + 1] / 2;
            uf.union(c1, c2);
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < couples; i++) {
            int root = uf.find(i);
            map.put(root, map.getOrDefault(root, 0) + 1);
        }

        int ans = 0;

        for (int size : map.values()) {
            ans += size - 1;
        }

        return ans;
    }

    class UnionFind {
        int[] parent, rank;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++)
                parent[i] = i;
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

            if (rank[px] < rank[py])
                parent[px] = py;
            else if (rank[px] > rank[py])
                parent[py] = px;
            else {
                parent[py] = px;
                rank[px]++;
            }
        }
    }
}