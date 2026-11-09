class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] result = new int[n];
        int index = 0;
        for (int num : nums) {
            if (num < pivot) {
                result[index++] = num;
            }
        }
        for (int num : nums) {
            if (num == pivot) {
                result[index++] = num;
            }
        }
        for (int num : nums) {
            if (num > pivot) {
                result[index++] = num;
            }
        }
        return result;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna