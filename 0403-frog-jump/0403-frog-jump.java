class Solution {
    public boolean canCross(int[] stones) {
        int len=stones.length;
        HashMap<Integer,HashSet<Integer>> map=new HashMap<>();
        for(int i=0;i<stones.length;i++){
            map.put(stones[i],new HashSet<>());
        }
        map.get(0).add(1);
        for(int i=0;i<stones.length;i++){
            int src=stones[i];
            for(int n:map.get(src)){
                int desStone=src+n;
                if(desStone==stones[len-1]){
                    return true;
                }
                if(map.containsKey(desStone)){
                    if (n-1 > 0) {
                        map.get(desStone).add(n-1);
                    }
                    map.get(desStone).add(n);
                    map.get(desStone).add(n+1);
                }
            }
        }
        return false;
    }
}