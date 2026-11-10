
class Solution {
    public int maxSubarrayLength(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            map.put(nums[right],map.getOrDefault(nums[right], 0) + 1);
            while (map.get(nums[right]) > k) {
                int num = nums[left];
                map.put(num, map.get(num) - 1);
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna