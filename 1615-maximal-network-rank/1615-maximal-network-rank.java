class Solution {

    public int maximalNetworkRank(int n, int[][] roads) {

        int[] degree = new int[n];
        boolean[][] connected = new boolean[n][n];

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];

            degree[u]++;
            degree[v]++;

            connected[u][v] = true;
            connected[v][u] = true;
        }

        int maxRank = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                int rank = degree[i] + degree[j];

                if (connected[i][j])
                    rank--;

                maxRank = Math.max(maxRank, rank);
            }
        }

        return maxRank;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna