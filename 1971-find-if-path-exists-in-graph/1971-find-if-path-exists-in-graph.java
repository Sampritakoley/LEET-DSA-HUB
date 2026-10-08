class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        ArrayList<Integer>[] graph=new ArrayList[n];
        for(int i=0; i<n; i++){
            graph[i]=new ArrayList<>();
        }

        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }
        boolean[] visited=new boolean[n];
        return dfs(source,destination,graph,visited);
    }
    private boolean dfs(int source,int destination, ArrayList<Integer>[] graph, boolean[] visited){
        if(destination==source){
            return true;
        }
        visited[source]=true;
        for(int next:graph[source]){
            if(!visited[next]){
                if(dfs(next,destination,graph,visited)){
                    return true;
                }
            }
        }
        return false;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna