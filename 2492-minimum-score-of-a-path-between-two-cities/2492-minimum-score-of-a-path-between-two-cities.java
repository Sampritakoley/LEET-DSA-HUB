class Solution {

    int[] parent;

    public int minScore(int n, int[][] roads) {

        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];

            union(a, b);
        }

        int root = find(1);

        int answer = Integer.MAX_VALUE;
        for (int[] road : roads) {

            int a = road[0];
            int distance = road[2];

            if (find(a) == root) {
                answer = Math.min(answer, distance);
            }
        }

        return answer;
    }

    private int find(int x) {

        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    private void union(int a, int b) {

        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rootA] = rootB;
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna