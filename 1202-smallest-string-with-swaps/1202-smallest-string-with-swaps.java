class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        UnionFind uf = new UnionFind(n);

        for (List<Integer> pair : pairs) {
            uf.union(pair.get(0), pair.get(1));
        }

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            map.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
        }

        char[] ans = s.toCharArray();

        for (List<Integer> indices : map.values()) {

            List<Character> chars = new ArrayList<>();

            for (int idx : indices) {
                chars.add(s.charAt(idx));
            }

            Collections.sort(indices);
            Collections.sort(chars);

            for (int i = 0; i < indices.size(); i++) {
                ans[indices.get(i)] = chars.get(i);
            }
        }

        return new String(ans);
    }

    class UnionFind {
        int[] parent;
        int[] rank;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);

            return parent[x];
        }

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px == py)
                return;

            if (rank[px] < rank[py])
                parent[px] = py;
            else if (rank[px] > rank[py])
                parent[py] = px;
            else {
                parent[py] = px;
                rank[px]++;
            }
        }
    }
}