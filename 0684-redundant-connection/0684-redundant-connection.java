class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Union uf=new Union(edges.length);
        for(int[] ed:edges){
           int u=ed[0];
           int v=ed[1];
           boolean res=uf.UnionFind(u,v);
           if(res){
              return new int[]{u,v};
           }
        }
        return null;
    }public class Union{
        int[] parent;
        int[] rank;
        public Union(int n){
            parent=new int[n+1];
            rank=new int[n+1];
            for (int i = 0; i <= n; i++) {
               parent[i] = i;
               rank[i] = 0;
            }
        }
        public int parent(int u){
            if(parent[u]!=u){
                parent[u] = parent(parent[u]);
            }
            return parent[u];
        }
        public boolean UnionFind(int u,int v){
            int pu=parent(u);
            int pv=parent(v);
            if(pu==pv){
               return true;
            }

            if(rank[pu]==rank[pv]){
                parent[pu]=pv;
                rank[pv]++;
            }else if(rank[pu]<rank[pv]){
                parent[pu]=pv;
            }else{
                parent[pv]=pu;
            }
            return false;
        }
    }
}