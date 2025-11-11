class Solution {
    public static class Pair{
        int n;
        int cost;
        int stopage;
        public Pair(int n,int cost,int stopage){
            this.n=n;
            this.cost=cost;
            this.stopage=stopage;
        }
    }
    public int findCheapestPrice(int n, int[][] flights,
     int src, int dst, int k) {
        Queue<Pair> q=new LinkedList<>();
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int cst = flight[2];
            graph[u].add(new int[]{v, cst});
        }

        int[] mincost=new int[n];
        Arrays.fill(mincost,Integer.MAX_VALUE);
        mincost[src]=0;
        int ans=Integer.MAX_VALUE;
        q.add(new Pair(src,0,0));
        while(q.size()>0){
            Pair p=q.poll();
            if(dst==p.n){
                ans=Math.min(ans,p.cost);
            }
            if (p.stopage > k) continue;

            for (int[] edge : graph[p.n]) {
                int nb_n = edge[0];
                int nb_ct = edge[1];
                int newcost = p.cost + nb_ct;

                if (newcost < mincost[nb_n]) {
                    mincost[nb_n] = newcost;
                    q.offer(new Pair(nb_n, newcost, p.stopage + 1));
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}