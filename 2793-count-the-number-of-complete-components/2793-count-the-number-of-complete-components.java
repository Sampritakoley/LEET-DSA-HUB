class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        boolean[] visited=new boolean[n];
        ArrayList<Integer>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<Integer>();
        }

        for(int i=0;i<edges.length;i++){
            int[] e=edges[i];
            int v1=e[0];
            int v2=e[1];
            adj[v1].add(v2);
            adj[v2].add(v1);
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(visited[i]==false){
                List<Integer> list=new ArrayList<>();
                findConnectPair(i,adj,visited,list);
                int ncount=list.size();
                int ecount=0;
                for(int v:list){
                    ecount+=adj[v].size();
                }

                ecount=ecount/2;

                if (ecount == ncount * (ncount - 1) / 2) {
                    count++;
                }
            }
        }
        return count;

    }

    public static void findConnectPair(int s,ArrayList<Integer>[] adj,boolean[] visited,List<Integer> list){
         visited[s]=true;
         list.add(s);
         for(int e:adj[s]){
            if(visited[e]==false){
                findConnectPair(e,adj,visited,list);
            }
         }
    }
}