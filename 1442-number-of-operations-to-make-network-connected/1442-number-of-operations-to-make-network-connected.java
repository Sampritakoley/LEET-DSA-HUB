class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1){
            return -1;
        }
        DSU dsu=new DSU(n);
        for(int[] con:connections){
            int u=con[0];
            int v=con[1];
            dsu.union(u,v);
        }
        int comp=0;
        for(int i=0;i<n;i++){
            if(dsu.findPar(i)==i){
                comp++;
            }
        }
        return comp-1;
    }
    public class DSU{
        public static int[] parent;
        public static int[] size;
        public DSU(int n){
            this.parent=new int[n];
            this.size=new int[n];
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