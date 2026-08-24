class Solution {
    public int firstMissingPositive(int[] nums) {

        int n = nums.length;

        // Put each number in its correct position
        for (int i = 0; i < n; i++) {

            while (
                nums[i] >= 1 &&
                nums[i] <= n &&
                nums[nums[i] - 1] != nums[i]
            ) {

                int correctIndex = nums[i] - 1;

                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }
        }

        // Find first number that is not in its correct position
        for (int i = 0; i < n; i++) {

            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // All 1...n are present
        return n + 1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna