class Solution {

    class UnionFind {

        int[] parent;
        int[] rank;

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

        boolean union(int x, int y) {

            int px = find(x);
            int py = find(y);

            if (px == py)
                return false;

            if (rank[px] < rank[py]) {
                parent[px] = py;
            } else if (rank[px] > rank[py]) {
                parent[py] = px;
            } else {
                parent[py] = px;
                rank[px]++;
            }

            return true;
        }
    }

    private int kruskal(
            int n,
            int[][] edges,
            int skip,
            int force) {

        UnionFind uf = new UnionFind(n);

        int weight = 0;
        int count = 0;

        if (force != -1) {

            int[] e = edges[force];

            if (uf.union(e[0], e[1])) {
                weight += e[2];
                count++;
            }
        }

        for (int i = 0; i < edges.length; i++) {

            if (i == skip)
                continue;

            int[] e = edges[i];

            if (uf.union(e[0], e[1])) {
                weight += e[2];
                count++;
            }
        }

        return count == n - 1
                ? weight
                : Integer.MAX_VALUE;
    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(
            int n,
            int[][] edges) {

        int m = edges.length;

        int[][] newEdges = new int[m][4];

        for (int i = 0; i < m; i++) {
            newEdges[i] = new int[]{
                    edges[i][0],
                    edges[i][1],
                    edges[i][2],
                    i
            };
        }

        Arrays.sort(newEdges,
                (a, b) -> a[2] - b[2]);

        int mstWeight =
                kruskal(n, newEdges, -1, -1);

        List<Integer> critical =
                new ArrayList<>();

        List<Integer> pseudo =
                new ArrayList<>();

        for (int i = 0; i < m; i++) {

            if (kruskal(n, newEdges, i, -1)> mstWeight) {
                critical.add(newEdges[i][3]);
            } else if (kruskal(n, newEdges, -1, i)== mstWeight) {
                pseudo.add(newEdges[i][3]);
            }
        }

        return Arrays.asList(
                critical,
                pseudo
        );
    }
}