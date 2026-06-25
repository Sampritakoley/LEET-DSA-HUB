class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] cost=new int[n];
        Arrays.fill(cost,Integer.MAX_VALUE);
        int count=0; cost[src]=0;
        while(k>=count){
            int[] temp=cost.clone();
            for(int i=0;i<flights.length;i++){
                int[] f=flights[i];
                int u=f[0];
                int v=f[1];
                int p=f[2];

                if(cost[u]!=Integer.MAX_VALUE){
                    temp[v]=Math.min(temp[v],cost[u]+p);
                }
            }
            cost=temp;
            count++;
        }
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}