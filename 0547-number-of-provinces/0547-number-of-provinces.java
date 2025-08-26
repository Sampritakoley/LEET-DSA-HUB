class Solution {
  
    public int findCircleNum(int[][] isConnected) {
        DSU dsu=new DSU(isConnected.length);
        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected[0].length;j++){
                if(isConnected[i][j]==1){
                    dsu.union(i,j);
                }
            }
        }
        int provinces=0;
        for(int i=0;i<isConnected.length;i++){
            if(i==dsu.findPar(i)){
                provinces++;
            }
        }
        return provinces;
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

