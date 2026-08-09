class Solution {

    public int regionsBySlashes(String[] grid) {

        int n = grid.length;

        // 4 triangles per cell
        // 0 = top
        // 1 = left
        // 2 = right
        // 3 = bottom
        int totalNodes = n * n * 4;

        UnionFind uf = new UnionFind(totalNodes);

        for (int r = 0; r < n; r++) {

            for (int c = 0; c < n; c++) {

                int base = (r * n + c) * 4;

                int top = base;
                int left = base + 1;
                int right = base + 2;
                int bottom = base + 3;

                char ch = grid[r].charAt(c);

                // -------------------------
                // Inside current cell
                // -------------------------

                if (ch == '/') {

                    // '/' connects top-left
                    // and right-bottom

                    uf.union(top, left);
                    uf.union(right, bottom);

                } else if (ch == '\\') {

                    // '\' connects top-right
                    // and left-bottom

                    uf.union(top, right);
                    uf.union(left, bottom);

                } else {

                    // Blank cell:
                    // all four parts connected

                    uf.union(top, left);
                    uf.union(top, right);
                    uf.union(top, bottom);
                }

                // -------------------------
                // Connect right neighbor
                // -------------------------

                if (c + 1 < n) {

                    int rightBase =
                        (r * n + c + 1) * 4;

                    int rightCellLeft = rightBase + 1;

                    uf.union(right, rightCellLeft);
                }

                // -------------------------
                // Connect bottom neighbor
                // -------------------------

                if (r + 1 < n) {

                    int bottomBase =
                        ((r + 1) * n + c) * 4;

                    int bottomCellTop = bottomBase;

                    uf.union(bottom, bottomCellTop);
                }
            }
        }

        // Count connected components

        int regions = 0;

        for (int i = 0; i < totalNodes; i++) {

            if (uf.find(i) == i) {
                regions++;
            }
        }

        return regions;
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

    int find(int x) {

        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    void union(int a, int b) {

        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) {
            return;
        }

        if (size[rootA] < size[rootB]) {

            parent[rootA] = rootB;
            size[rootB] += size[rootA];

        } else {

            parent[rootB] = rootA;
            size[rootA] += size[rootB];
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna