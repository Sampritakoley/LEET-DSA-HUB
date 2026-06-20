class Solution {
    public class Pair{
        public int src;
        public int color;
        public Pair(int src,int color){
            this.src=src;
            this.color=color;
        }
    }
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        Queue<Pair> q=new LinkedList<>();
        int[] visited=new int[n];
        Arrays.fill(visited,-1);
        for(int i=0;i<n;i++){
            if(visited[i]!=-1){
                continue;
            }
            q.offer(new Pair(i,1)); 
            while(q.size()>0){
            Pair c=q.poll();
            if(visited[c.src]!=-1){
                if(visited[c.src]!=c.color){
                    return false;
                }else{
                    continue;
                }
            }
            visited[c.src]=c.color;
            for(int nb:graph[c.src]){
                if(visited[nb]==-1){
                    q.offer(new Pair(nb,1-c.color));
                }
            }
         }
        }
        return true;
    }
}