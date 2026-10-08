class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> resultPath=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        int src=0; int des=graph.length-1;
        dfs(src,des,resultPath,path,graph);
        return resultPath;
    }public void dfs(int src,int des, List<List<Integer>> resultPath,List<Integer> path,int[][] graph){
        path.add(src);
        if(src==des){
            resultPath.add(new ArrayList<>(path));
        }
        for(int next:graph[src]){
            dfs(next,des,resultPath,path,graph);
        }
        path.remove(path.size()-1);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna