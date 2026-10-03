class Solution {

    int[] parent;
    int[] size;

    public int numberOfGoodPaths(int[] vals, int[][] edges) {

        int n = vals.length;

        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(vals[i], k -> new ArrayList<>())
               .add(i);
        }

        int answer = n; 
        for (int value : map.keySet()) {

            List<Integer> nodes = map.get(value);
            for (int node : nodes) {

                for (int neighbor : graph[node]) {

                    if (vals[neighbor] <= value) {
                        union(node, neighbor);
                    }
                }
            }
            Map<Integer, Integer> count = new HashMap<>();

            for (int node : nodes) {

                int root = find(node);

                count.put(root, count.getOrDefault(root, 0) + 1);
            }
            for (int k : count.values()) {
                answer += k * (k - 1) / 2;
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