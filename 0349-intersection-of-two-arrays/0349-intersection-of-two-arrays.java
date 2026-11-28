class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set = new HashSet<>();

        for (int num : nums1) {
            for (int x : nums2) {
                if (num == x) {
                    set.add(num);
                    break;
                }
            }
        }

        int[] result = new int[set.size()];
        int i = 0;

        for (int num : set) {
            result[i++] = num;
        }

        return result;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna