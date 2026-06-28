class Solution {

    public int makeConnected(int n, int[][] connections) {

        if (connections.length < n - 1)
            return -1;

        UnionFind uf = new UnionFind(n);

        int extraEdges = 0;

        for (int[] edge : connections) {

            int u = edge[0];
            int v = edge[1];

            if (!uf.union(u, v))
                extraEdges++;
        }

        int components = 0;

        for (int i = 0; i < n; i++) {

            if (uf.find(i) == i)
                components++;
        }

        int requiredEdges = components - 1;

        return (extraEdges >= requiredEdges) ? requiredEdges : -1;
    }
}

class UnionFind {

    int[] parent;
    int[] rank;

    UnionFind(int n) {

        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++)
            parent[i] = i;
    }

    int find(int node) {

        if (parent[node] == node)
            return node;

        return parent[node] = find(parent[node]);
    }

    boolean union(int u, int v) {

        int pu = find(u);
        int pv = find(v);

        if (pu == pv)
            return false;

        if (rank[pu] < rank[pv]) {

            parent[pu] = pv;

        } else if (rank[pv] < rank[pu]) {

            parent[pv] = pu;

        } else {

            parent[pv] = pu;
            rank[pu]++;
        }

        return true;
    }
}