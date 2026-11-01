class Solution {
    public int findLHS(int[] nums) {

        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int maxLen = 0;
        for (int num : freq.keySet()) {

            if (num != Integer.MAX_VALUE &&
                freq.containsKey(num + 1)) {

                int count = freq.get(num) + freq.get(num + 1);

                maxLen = Math.max(maxLen, count);
            }
        }

        return maxLen;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna