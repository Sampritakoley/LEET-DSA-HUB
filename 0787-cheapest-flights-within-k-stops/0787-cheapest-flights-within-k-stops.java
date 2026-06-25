class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] flight : flights) {
            graph[flight[0]].add(new int[]{flight[1], flight[2]});
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0});

        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[src] = 0;

        int stops = 0;

        while (!queue.isEmpty() && stops <= k) {

            int size = queue.size();

            while (size-- > 0) {

                int[] curr = queue.poll();
                int city = curr[0];
                int cost = curr[1];

                for (int[] neighbor : graph[city]) {

                    int nextCity = neighbor[0];
                    int nextCost = cost + neighbor[1];

                    if (nextCost < minCost[nextCity]) {
                        minCost[nextCity] = nextCost;
                        queue.offer(new int[]{nextCity, nextCost});
                    }
                }
            }

            stops++;
        }

        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }
}