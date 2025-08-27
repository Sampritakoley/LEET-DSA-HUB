class Solution {
    public int largestIsland(int[][] grid) {
        int[] x=new int[]{0,0,1,-1};
        int[] y=new int[]{1,-1,0,0};
        int n=grid.length;
        int m=grid[0].length;
        DSU dsu=new DSU(n*m);
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]!=1){
                    continue;
                }
                int id=i*n+j;
                for(int k=0;k<4;k++){
                    int ni=i+x[k];
                    int nj=j+y[k];
                    int nid=(ni*n)+nj;
                    if(ni>=0 && nj>=0 && ni<n && nj<m && grid[ni][nj]==1){
                        dsu.union(id,nid);
                    }
                }
            }
        }
        int maxArea=0;int area=1;
        boolean hasZero=false;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                HashSet<Integer> set=new HashSet<>();
                if(grid[i][j]==0){
                    hasZero=true;
                    area = 1; 
                    for(int k=0;k<4;k++){
                        int nr=i+x[k];
                        int nc=j+y[k];
                        int nid=nr*n+nc;
                        if(nr>=0 && nc>=0 && nr<n && nc<m && grid[nr][nc]==1){
                            int root = dsu.findPar(nid);
                            if(set.add(root)){
                                area+=dsu.size[root];
                            }
                        }
                    }
                }
                maxArea = Math.max(maxArea, area);
            }
        }
        if (!hasZero) return n * m;
        return maxArea;
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