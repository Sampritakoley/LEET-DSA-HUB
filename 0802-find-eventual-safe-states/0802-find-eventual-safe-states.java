class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v=graph.length;
        List<Integer> res=new ArrayList<>();
        boolean[] visited=new boolean[v];
        boolean[] path=new boolean[v];
        boolean[] isSafe=new boolean[v];
        Arrays.fill(isSafe,true);
        for(int i=0;i<v;i++){
            if(!visited[i]){
                if(!dfs(i,path,visited,isSafe,graph)){
                     isSafe[i]=false;
                }
            }
        }
        for (int i = 0; i < v; i++) {
            if (isSafe[i]) {
                res.add(i);
            }
        }

        return res;
    }
    public static boolean dfs(int src,boolean[] path,boolean[] visited,boolean[] isSafe,int[][] graph){
        visited[src]=true;
        path[src]=true;
        for(int nb:graph[src]){
            if (!visited[nb]){
                if(!dfs(nb,path,visited,isSafe,graph)){
                     path[nb]=false;
                     isSafe[nb]=false;
                     return false;
                }
            }else{
                if(path[nb] || !isSafe[nb]){
                   path[nb]=false;
                   isSafe[nb]=false;
                   return false;
                }
            }
        }
        path[src]=false;
        return isSafe[src];
    }
}