class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        int[] visited=new int[n];
        Arrays.fill(visited, -1);
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Integer>();
        }
        for(int i=0;i<dislikes.length;i++){
            int[] row=dislikes[i];
            int v1 = row[0] - 1;
            int v2 = row[1] - 1;
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        for(int i=0;i<n;i++){
            if(visited[i]==-1){
               if(!isBipartite(graph,visited,i)){
                return false;
               }
            }
        }
        return true;
    }
    static class Pair {
        int v;
        int color;

        public Pair(int v, int color) {
            this.v = v;
            this.color = color;
        }
    }
    public static boolean isBipartite(ArrayList<Integer>[] graph,int[] visited,int scr){
         Queue<Pair> q = new ArrayDeque<>();
         q.add(new Pair(scr, 0));
         while(q.size()>0){
            Pair p=q.poll();
            if(visited[p.v]!=-1){
                if(visited[p.v]!=p.color){
                    return false;
                }
            }else{
                visited[p.v]=p.color;
            }

            for(int n:graph[p.v]){
                if(visited[n]==-1){
                    q.add(new Pair(n,1 - p.color));
                }else if(visited[n]==p.color){
                    return false;
                }
            }
           
        }
         return true;
    }
}