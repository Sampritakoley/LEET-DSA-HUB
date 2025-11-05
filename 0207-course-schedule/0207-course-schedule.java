class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph=new ArrayList[numCourses];
        int cmpt=0;
        int[] indegree=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<prerequisites.length;i++){
            int cource=prerequisites[i][0];
            int preReq=prerequisites[i][1];
            graph[preReq].add(cource);
            indegree[cource]++;
        }
        Queue<Integer> que=new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                que.add(i);
            }
        }
        while(que.size()>0){
            cmpt++;
            int node=que.poll();
            for (int next : graph[node]) {

                indegree[next]--;

                if (indegree[next] == 0) {
                    que.add(next);
                }
            }
        }
        return cmpt==numCourses?true:false;
    }
}