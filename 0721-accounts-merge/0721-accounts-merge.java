class Solution {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        int n = accounts.size();

        UnionFind uf = new UnionFind(n);

        HashMap<String, Integer> mailToNode = new HashMap<>();

        for (int i = 0; i < n; i++) {

            List<String> account = accounts.get(i);

            for (int j = 1; j < account.size(); j++) {

                String mail = account.get(j);

                if (!mailToNode.containsKey(mail)) {
                    mailToNode.put(mail, i);
                } else {
                    uf.union(i, mailToNode.get(mail));
                }
            }
        }

        ArrayList<String>[] mergedMail = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            mergedMail[i] = new ArrayList<>();
        }

        for (Map.Entry<String, Integer> entry : mailToNode.entrySet()) {

            String mail = entry.getKey();
            int node = entry.getValue();

            int parent = uf.find(node);

            mergedMail[parent].add(mail);
        }

        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (mergedMail[i].size() == 0)
                continue;

            Collections.sort(mergedMail[i]);

            List<String> temp = new ArrayList<>();

            temp.add(accounts.get(i).get(0));

            temp.addAll(mergedMail[i]);

            ans.add(temp);
        }

        return ans;
    }
}

class UnionFind {

    int[] parent;
    int[] rank;

    UnionFind(int n) {

        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    int find(int node) {

        if (parent[node] == node)
            return node;

        return parent[node] = find(parent[node]);
    }

    void union(int u, int v) {

        int pu = find(u);
        int pv = find(v);

        if (pu == pv)
            return;

        if (rank[pu] < rank[pv]) {

            parent[pu] = pv;

        } else if (rank[pv] < rank[pu]) {

            parent[pv] = pu;

        } else {

            parent[pv] = pu;
            rank[pu]++;
        }
    }
}