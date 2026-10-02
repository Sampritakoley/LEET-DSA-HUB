class Solution {
    int[] parent;
    int[] rank;
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        parent=new int[n];
        rank=new int[n];

        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        
        for (int i = 1; i < n; i++) {

            long diff = (long) arr[i][0] - arr[i - 1][0];

            if (diff <= maxDiff) {
                union(arr[i][1], arr[i - 1][1]);
            }
        }

        int i=0;
        boolean[] ans=new boolean[queries.length];
        for(int[] num:queries){
            if(findParent(num[0])==findParent(num[1])){
                ans[i]=true;
            }else{
                ans[i]=false;
            }
            i++;
        }
        return ans;
        
    }
    private int findParent(int u){
        if(parent[u]!=u){
            parent[u]=findParent(parent[u]);
        }
        return parent[u];
    }
    private void union(int u,int v){
         int pu=findParent(u);
         int pv=findParent(v);

         if(pv==pu){
            return;
         }

         if(rank[pv]==rank[pu]){
            parent[pu]=pv;
            rank[pv]++;
         }else if(rank[pv]>rank[pu]){
             parent[pu]=pv;
         }else{
             parent[pv]=pu;
         }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna