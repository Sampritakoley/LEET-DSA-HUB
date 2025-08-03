class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        ArrayList<Integer>[] graph = new ArrayList[n];
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(isConnected[i][j]==1){
                    graph[i].add(j);
                    graph[j].add(i);
                    isConnected[j][i]=0;
                }
            }
        }
        int count=0;
        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
                count++;
                dfs(graph,i,visited);
            }
        }
        return count;
    }
    public static void dfs(ArrayList<Integer>[] graph,int scr,boolean[] visited){
        visited[scr]=true;
        for(int nbr:graph[scr]){
            if(!visited[nbr]){
                dfs(graph,nbr,visited);
            }
        }
    }
}