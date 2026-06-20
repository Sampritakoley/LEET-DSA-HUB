class Solution {
    public class Pair{
        int src;
        int grp;
        public Pair(int src,int grp){
            this.src=src;
            this.grp=grp;
        }
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<Integer>[] graph=new ArrayList[n+1];
        int[] visited=new int[n+1];
        Arrays.fill(visited,-1);
        for(int i=0;i<=n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<dislikes.length;i++){
            int v=dislikes[i][0];
            int u=dislikes[i][1];
            graph[u].add(v);
            graph[v].add(u);
        }
        Queue<Pair> q=new LinkedList<>();
        for(int i=1;i<n+1;i++){
            if(visited[i]!=-1){
                continue;
            }
            q.add(new Pair(i,0));
        while(q.size()>0){
            Pair c=q.poll();
            if(visited[c.src]!=-1){
                if(visited[c.src]!=c.grp){
                    return false;
                }
                continue;
            }
            visited[c.src]=c.grp;
            for(int nb:graph[c.src]){
                if(visited[nb]==-1){
                    q.offer(new Pair(nb,1-c.grp));
                }
            }
        }
        }
        return true;
    }
}