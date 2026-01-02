class Solution {
    public boolean canCross(int[] stones) {
         if (stones.length > 1 && stones[1] != 1) {
            return false;
        }
        Map<Integer,Set<Integer>> dp=new HashMap<>();
        for(int stone:stones){
            dp.put(stone,new HashSet<>());
        }

        dp.get(0).add(0);
        for(int stone:stones){
            for(int jump:dp.get(stone)){
                for(int nextJump=jump-1;nextJump<=jump+1;nextJump++){
                    if(nextJump>0){
                        int nextStone=stone+nextJump;
                        if(dp.containsKey(nextStone)){
                            dp.get(nextStone).add(nextJump);
                        }
                    }
                }
            }
        }
        return !dp.get(stones[stones.length-1]).isEmpty();
    }
}