class Solution {

    int[] parent;
    int[] size;

    public int latestDayToCross(int row, int col, int[][] cells) {

        int total = row * col;

        int top = total;
        int bottom = total + 1;

        parent = new int[total + 2];
        size = new int[total + 2];

        for (int i = 0; i < total + 2; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        boolean[][] land = new boolean[row][col];
        for (int day = cells.length - 1; day >= 0; day--) {

            int r = cells[day][0] - 1;
            int c = cells[day][1] - 1;
            land[r][c] = true;

            int current = r * col + c;
            if (r == 0) {
                union(current, top);
            }
            if (r == row - 1) {
                union(current, bottom);
            }

            int[] dr = {-1, 1, 0, 0};
            int[] dc = {0, 0, -1, 1};

            for (int k = 0; k < 4; k++) {

                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr >= 0 && nr < row &&
                    nc >= 0 && nc < col &&
                    land[nr][nc]) {

                    int neighbor = nr * col + nc;

                    union(current, neighbor);
                }
            }
            if (find(top) == find(bottom)) {
                return day;
            }
        }

        return 0;
    }

    int find(int x) {

        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    void union(int a, int b) {

        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) {
            return;
        }
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