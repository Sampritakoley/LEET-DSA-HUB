class Solution {

    int[] parent;
    int[] rank;

    public boolean containsCycle(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        parent = new int[m * n];
        rank = new int[m * n];

        for (int i = 0; i < m * n; i++) {
            parent[i] = i;
        }

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                if (c + 1 < n &&
                    grid[r][c] == grid[r][c + 1]) {

                    int u = r * n + c;
                    int v = r * n + (c + 1);

                    if (!union(u, v)) {
                        return true;
                    }
                }

                if (r + 1 < m &&
                    grid[r][c] == grid[r + 1][c]) {

                    int u = r * n + c;
                    int v = (r + 1) * n + c;

                    if (!union(u, v)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    private boolean union(int a, int b) {

        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) {
            return false;
        }

        if (rank[rootA] < rank[rootB]) {
            parent[rootA] = rootB;
        }
        else if (rank[rootA] > rank[rootB]) {
            parent[rootB] = rootA;
        }
        else {
            parent[rootB] = rootA;
            rank[rootA]++;
        }

        return true;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna