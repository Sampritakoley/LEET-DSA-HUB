
import java.util.*;

class Solution {
    private static final int MOD = 1_000_000_007;

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        int n = edges.length + 1;

        int LOG = 1;
        while ((1 << LOG) <= n) {
            LOG++;
        }

        List<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        int[][] up = new int[LOG][n + 1];
        int[] depth = new int[n + 1];
        int[] stack = new int[n];
        int top = 0;
        stack[top++] = 1;

        boolean[] visited = new boolean[n + 1];
        visited[1] = true;

        while (top > 0) {
            int node = stack[--top];

            for (int next : graph[node]) {
                if (visited[next]) {
                    continue;
                }

                visited[next] = true;
                depth[next] = depth[node] + 1;
                up[0][next] = node;

                stack[top++] = next;
            }
        }
        for (int k = 1; k < LOG; k++) {
            for (int node = 1; node <= n; node++) {
                up[k][node] =
                    up[k - 1][up[k - 1][node]];
            }
        }
        int[] pow2 = new int[n + 1];
        pow2[0] = 1;

        for (int i = 1; i <= n; i++) {
            pow2[i] = (int) (
                (long) pow2[i - 1] * 2 % MOD
            );
        }

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];

            int ancestor = lca(u, v, depth, up, LOG);

            int distance = depth[u] + depth[v]
                         - 2 * depth[ancestor];

            if (distance == 0) {
                answer[i] = 0;
            } else {
                answer[i] = pow2[distance - 1];
            }
        }

        return answer;
    }

    private int lca(
        int u,
        int v,
        int[] depth,
        int[][] up,
        int LOG
    ) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }
        int diff = depth[u] - depth[v];

        for (int k = LOG - 1; k >= 0; k--) {
            if ((diff & (1 << k)) != 0) {
                u = up[k][u];
            }
        }

        if (u == v) {
            return u;
        }
        for (int k = LOG - 1; k >= 0; k--) {
            if (up[k][u] != up[k][v]) {
                u = up[k][u];
                v = up[k][v];
            }
        }

        return up[0][u];
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna