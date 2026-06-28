class Solution {

    public int removeStones(int[][] stones) {

        int maxRow = 0;
        int maxCol = 0;

        for (int[] stone : stones) {
            maxRow = Math.max(maxRow, stone[0]);
            maxCol = Math.max(maxCol, stone[1]);
        }

        UnionFind uf = new UnionFind(maxRow + maxCol + 2);

        HashSet<Integer> usedNodes = new HashSet<>();

        for (int[] stone : stones) {

            int rowNode = stone[0];
            int colNode = stone[1] + maxRow + 1;

            uf.union(rowNode, colNode);

            usedNodes.add(rowNode);
            usedNodes.add(colNode);
        }
        int components = 0;
        for (int node : usedNodes) {
            if (uf.find(node) == node)
                components++;
        }
        return stones.length - components;
    }
}

class UnionFind {

    int[] parent;
    int[] size;

    UnionFind(int n) {

        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int find(int node) {

        if (parent[node] == node)
            return node;

        return parent[node] = find(parent[node]);
    }

    void union(int u, int v) {

        int pu = find(u);
        int pv = find(v);

        if (pu == pv)
            return;

        if (size[pu] < size[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        } else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }
}