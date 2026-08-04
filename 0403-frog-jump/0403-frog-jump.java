class Solution {
    public boolean canCross(int[] stones) {

        int n = stones.length;

        Map<Integer, Set<Integer>> dp = new HashMap<>();

        for (int stone : stones) {
            dp.put(stone, new HashSet<>());
        }

        dp.get(0).add(0);

        for (int stone : stones) {

            for (int jump : dp.get(stone)) {

                for (int nextJump = jump - 1;
                     nextJump <= jump + 1;
                     nextJump++) {

                    if (nextJump <= 0) {
                        continue;
                    }

                    int nextPosition = stone + nextJump;

                    if (dp.containsKey(nextPosition)) {

                        if (nextPosition == stones[n - 1]) {
                            return true;
                        }

                        dp.get(nextPosition).add(nextJump);
                    }
                }
            }
        }

        return false;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna