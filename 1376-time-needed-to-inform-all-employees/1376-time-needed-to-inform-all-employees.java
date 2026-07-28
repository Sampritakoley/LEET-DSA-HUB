class Solution {

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (manager[i] != -1)
                graph[manager[i]].add(i);
        }

        return dfs(headID, graph, informTime);
    }

    private int dfs(int employee, List<Integer>[] graph, int[] informTime) {

        int maxChildTime = 0;

        for (int child : graph[employee]) {
            maxChildTime = Math.max(maxChildTime,
                    dfs(child, graph, informTime));
        }

        return informTime[employee] + maxChildTime;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna