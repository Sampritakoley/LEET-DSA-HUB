class Solution {
     public long countBadPairs(int[] nums) {
        int n = nums.length;
        long totalPairs = (long) n * (n - 1) / 2;

        Map<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int key = nums[i] - i;
            map.put(key, map.getOrDefault(key, 0L) + 1);
        }

        long goodPairs = 0;
        for (long count : map.values()) {
            goodPairs += count * (count - 1) / 2;
        }

        return totalPairs - goodPairs;
    }
}