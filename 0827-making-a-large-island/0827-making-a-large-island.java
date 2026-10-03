class Solution {

    int[] parent;
    int[] size;

    public int largestIsland(int[][] grid) {

        int n = grid.length;
        int total = n * n;

        parent = new int[total];
        size = new int[total];
        for (int i = 0; i < total; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {

                if (grid[r][c] == 0)
                    continue;

                int current = r * n + c;

                for (int k = 0; k < 4; k++) {

                    int nr = r + dr[k];
                    int nc = c + dc[k];

                    if (nr >= 0 && nr < n &&
                        nc >= 0 && nc < n &&
                        grid[nr][nc] == 1) {

                        int neighbor = nr * n + nc;

                        union(current, neighbor);
                    }
                }
            }
        }
        int answer = 0;

        for (int i = 0; i < total; i++) {
            if (grid[i / n][i % n] == 1) {
                answer = Math.max(answer, size[find(i)]);
            }
        }
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {

                if (grid[r][c] == 1)
                    continue;

                int newSize = 1;
                HashSet<Integer> set = new HashSet<>();

                for (int k = 0; k < 4; k++) {

                    int nr = r + dr[k];
                    int nc = c + dc[k];

                    if (nr >= 0 && nr < n &&
                        nc >= 0 && nc < n &&
                        grid[nr][nc] == 1) {

                        int neighbor = nr * n + nc;

                        int root = find(neighbor);

                        if (set.add(root)) {
                            newSize += size[root];
                        }
                    }
                }

                answer = Math.max(answer, newSize);
            }
        }

        return answer;
    }

    int find(int x) {

        if (parent[x] == x)
            return x;

        return parent[x] = find(parent[x]);
    }

    void union(int a, int b) {

        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB)
            return;

        if (size[rootA] < size[rootB]) {
            int temp = rootA;
            rootA = rootB;
            rootB = temp;
        }

        parent[rootB] = rootA;
        size[rootA] += size[rootB];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna