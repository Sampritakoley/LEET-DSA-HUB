class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        //build graph 
        //timeTaken[]
        //maxTime


        ArrayList<Integer>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }

        for(int i=0;i<manager.length;i++){
            if(manager[i]==-1){
                continue;
            }
            graph[manager[i]].add(i);
        }
        //node,timetaken
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{headID,0});
        int maxTime=0;
        while(!queue.isEmpty()){
            int[] current=queue.poll();
            int node=current[0];
            int timeTaken=current[1];
            maxTime=maxTime<timeTaken?timeTaken:maxTime;

            for(int next: graph[node]){
                int newTime=timeTaken+informTime[node];
                queue.offer(new int[]{next,newTime});
            }
        } 
        return maxTime;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna