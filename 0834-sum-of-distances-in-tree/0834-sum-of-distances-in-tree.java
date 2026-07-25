class Solution {

    List<Integer>[] graph;
    int[] subtree;
    int[] answer;
    int n;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {

        this.n = n;

        graph = new ArrayList[n];
        subtree = new int[n];
        answer = new int[n];

        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        dfs1(0, -1, 0);

        dfs2(0, -1);

        return answer;
    }

    private void dfs1(int node, int parent, int depth) {

        subtree[node] = 1;

        answer[0] += depth;

        for (int next : graph[node]) {

            if (next == parent)
                continue;

            dfs1(next, node, depth + 1);

            subtree[node] += subtree[next];
        }
    }

    private void dfs2(int node, int parent) {

        for (int next : graph[node]) {

            if (next == parent)
                continue;

            answer[next] =
                    answer[node]
                    + n
                    - 2 * subtree[next];

            dfs2(next, node);
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna