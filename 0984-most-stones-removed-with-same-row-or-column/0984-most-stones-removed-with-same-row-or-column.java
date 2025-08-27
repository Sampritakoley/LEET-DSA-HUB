class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int maxRow = 0, maxCol = 0;
        for (int[] s : stones) {
            maxRow = Math.max(maxRow, s[0]);
            maxCol = Math.max(maxCol, s[1]);
        }
        int offset = maxRow + 1;
        DSU dsu = new DSU(maxRow + maxCol + 2);
        for (int[] s : stones) {
            int r = s[0];
            int c = s[1] + offset;
            dsu.union(r, c);
        }
        HashSet<Integer> seen = new HashSet<>();
        for (int[] s : stones) {
            seen.add(dsu.findPar(s[0]));
            seen.add(dsu.findPar(s[1] + offset));
        }
        int components = seen.size();
        return n - components;
    }
    class DSU {
        int[] parent, size;

        public DSU(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int findPar(int u) {
            if (parent[u] != u) {
                parent[u] = findPar(parent[u]);
            }
            return parent[u];
        }

        public void union(int u, int v) {
            int pu = findPar(u);
            int pv = findPar(v);
            if (pu == pv) return;

            if (size[pu] < size[pv]) {
                parent[pu] = pv;
                size[pv] += size[pu];
            } else {
                parent[pv] = pu;
                size[pu] += size[pv];
            }
        }
    }
}
