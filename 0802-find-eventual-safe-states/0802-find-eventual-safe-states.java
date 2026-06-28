class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        buildParent(map,graph);
        int n=graph.length;
        int[] outdegree=new int[n];
        List<Integer> res=new ArrayList<>();
        if(n==0){
            return res;
        }
        int x=0;
        for(int[] g:graph){
            for(int num:g){
                outdegree[x]++;
            }
            x++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(outdegree[i]==0){
                q.offer(i);
            }
        }

        while(q.size()>0){
            int c=q.poll();
            if(map.get(c)==null){
                continue;
            }
            for(int p:map.get(c)){
                outdegree[p]--;
                if(outdegree[p]==0){
                    q.offer(p);
                }
            }
        }
        for(int i=0;i<n;i++){
            if(outdegree[i]==0){
               res.add(i);
            }
        }
        return res;
    }
    public void buildParent(HashMap<Integer,List<Integer>> map, int[][]graph){
        int i=0;
        for(int[] g:graph){
            for(int num:g){
                map.putIfAbsent(num,new ArrayList<>());
                map.get(num).add(i);
            }
            i++;
        }
    }
}