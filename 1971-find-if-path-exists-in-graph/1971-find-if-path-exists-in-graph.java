class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Integer>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        boolean[] visited=new boolean[n];

        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        Queue<Integer> queue=new LinkedList<>();
        queue.offer(source);
        visited[source]=true;

        while(!queue.isEmpty()){
            int current=queue.poll();
            if(current==destination){
                return true;
            }

            for(int next:graph[current]){
                if(!visited[next]){
                    if(next==destination){
                        return true;
                    }
                    queue.offer(next);
                    visited[next]=true;
                }
            }
        }
        return false;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna