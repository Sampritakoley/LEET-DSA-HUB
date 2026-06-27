class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        HashMap<Integer,HashSet<Integer>> map=new HashMap<>();
        buildMap(routes,map);
        Queue<Integer> q=new ArrayDeque<>();
        HashSet<Integer> visitedBus=new HashSet<>();
        HashSet<Integer> visitedStops = new HashSet<>();
        if(source==target){
            return 0;
        }
        q.add(source); visitedStops.add(source); int buses=1;
        while(q.size()>0){
            int size=q.size();
            while(size-- >0){
                Integer c=q.poll();
                if (!map.containsKey(c))
                continue;
                for(int bus:map.get(c)){
                    if(visitedBus.contains(bus)){
                       continue;
                    }
                    visitedBus.add(bus);
                    for(int stops:routes[bus]){
                        
                        if(stops==target){
                           return buses;
                        }
                        if(visitedStops.add(stops)){
                            q.offer(stops);
                        }
                    }
                }
            }
            buses++;
        }
        return -1;
    }public void buildMap(int[][] routes,HashMap<Integer,HashSet<Integer>> map){
        int i=0;
        for(int[] r:routes){
            for(int num:r){
                if(!map.containsKey(num)){
                    map.put(num,new HashSet<>());
                }
                map.get(num).add(i);
            }
            i++;
        }
    }
}