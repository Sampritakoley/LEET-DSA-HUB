class Solution {
    public class pair{
        int node;
        int tsf;
        public pair(int node,int tsf){
            this.node=node;
            this.tsf=tsf;
        }
    }
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.putIfAbsent(manager[i], new ArrayList<>());
            map.get(manager[i]).add(i);
        }
        Queue<pair> q=new LinkedList<>();
        q.offer(new pair(headID,0));int maxTime=0;
        while(q.size()>0){
            pair curr=q.poll();
            maxTime=Math.max(maxTime,curr.tsf);
            for(int ch:map.getOrDefault(curr.node, new ArrayList<>())){
                 q.offer(new pair(ch,curr.tsf+informTime[curr.node]));
            }
        }
        return maxTime;
    }
}