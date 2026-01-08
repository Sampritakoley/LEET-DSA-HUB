class Solution {
    public int maxJump(int[] stones) {
        if (stones.length== 2) {
            return stones[1] - stones[0];
        }
        int maxJump = 0;
        for (int i = 2; i < stones.length; i++) {
            maxJump = Math.max(maxJump, stones[i] - stones[i - 2]);
        }
        return maxJump;
    }
}