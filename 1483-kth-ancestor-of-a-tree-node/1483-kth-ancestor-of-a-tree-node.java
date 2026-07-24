class TreeAncestor {

    private int[][] mat;
    private int MAX = 17; 

    public TreeAncestor(int n, int[] parent) {

        mat = new int[MAX][n];

        for (int i = 0; i < n; i++) {
            mat[0][i] = parent[i];
        }

        for (int i = 1; i < MAX; i++) {
            for (int j = 0; j < n; j++) {

                int ancestor = mat[i-1][j];

                if (ancestor == -1) {
                    mat[i][j] = -1;
                } else {
                    mat[i][j] = mat[i-1][ancestor];
                }
            }
        }
    }

    public int getKthAncestor(int node, int k) {

        for (int i = 0; i < MAX; i++) {
            int mask=(1<<i);

            if ((k & (mask)) >0) {

                node = mat[i][node];

                if (node == -1) {
                    return -1;
                }
            }
        }

        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna