class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int INF=Integer.MAX_VALUE;
        int[][] dist=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                 if(i==j){
                    dist[i][j]=0;
                 }else{
                    dist[i][j]=INF;
                 }
            }
        }

        for(int[] e:edges){
            int v=e[0];
            int u=e[1];
            int w=e[2];

            dist[v][u]=w;
            dist[u][v]=w;
        }
        int minCity=Integer.MAX_VALUE;
        int ans=0;
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int cityCount = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= distanceThreshold) {
                    cityCount++;
                }
            }

            if (cityCount <= minCity) {
                minCity = cityCount;
                ans = i; 
            }
        }
        return ans; 

    }
}