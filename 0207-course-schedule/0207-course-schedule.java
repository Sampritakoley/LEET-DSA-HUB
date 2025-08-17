class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph=new ArrayList<>();
        int[] indegree=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<prerequisites.length;i++){
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        int count=0;
        while(q.size()!=0){
            int n=q.poll();
            count++;
            for(int nb:graph.get(n)){
                indegree[nb]--;
                if(indegree[nb]==0){
                    q.add(nb);
                }
            }
        }
        return count==numCourses;
    }
}