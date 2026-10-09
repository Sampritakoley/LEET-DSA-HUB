class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        HashMap<Integer,Integer> map=new HashMap<>();
        boolean[][] connect=new boolean[n][n];
        for(int[] road:roads){
            int u=road[0];
            int v=road[1];
            map.put(u,map.getOrDefault(u,0)+1);
            map.put(v,map.getOrDefault(v,0)+1);

            connect[u][v]=true;
            connect[v][u]=true;
        }
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j){
                    continue;
                }
                int total=map.getOrDefault(i,0)+map.getOrDefault(j,0);
                if(connect[i][j]){
                    total=total-1;
                }
                max=max<total?total:max;
            }
        }
        return max;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna