class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String,Integer> map=new HashMap<>();
        DSU dsu=new DSU(accounts.size());
        for(int i=0;i<accounts.size();i++){
            List<String> list=accounts.get(i);
            for(int j=1;j<list.size();j++){
                if(!map.containsKey(list.get(j))){
                    map.put(list.get(j),i);
                }else{
                    dsu.union(i, map.get(list.get(j)));
                }
            }
        }

        Map<Integer, TreeSet<String>> rootToEmails = new HashMap<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String email = entry.getKey();
            int root = dsu.findPar(entry.getValue());

            rootToEmails.computeIfAbsent(root, k -> new TreeSet<>()).add(email);
        }

        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<Integer, TreeSet<String>> entry : rootToEmails.entrySet()) {
            int root = entry.getKey();
            String name = accounts.get(root).get(0);

            List<String> merged = new ArrayList<>();
            merged.add(name);
            merged.addAll(entry.getValue());

            res.add(merged);
        }

        return res;
    }
    public static class DSU{
        public static int[] parent;
        public static int[] size;
        public DSU(int n){
            parent=new int[n];
            size=new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
                size[i]=1;
            }
        } 
        public static int findPar(int u){
            if(parent[u]!=u){
                parent[u]=findPar(parent[u]);
            }
            return parent[u];
        }
        public static void union(int u,int v){
            int pu=findPar(u);
            int pv=findPar(v);

            if(pu==pv){
                return;
            }else if(size[pu]<size[pv]){
                 parent[pu]=pv;
                 size[pv]+=size[pu];
            }else{
                parent[pv]=pu;
                size[pu]+=size[pv];
            }
        }
    }
}