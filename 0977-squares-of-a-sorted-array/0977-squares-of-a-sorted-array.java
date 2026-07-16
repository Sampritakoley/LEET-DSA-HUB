class Solution {
    public int[] sortedSquares(int[] nums) {

        int n = nums.length;

        int[] ans = new int[n];

        int left = 0;
        int right = n - 1;

        int index = n - 1;

        while (left <= right) {

            if (Math.abs(nums[left]) > Math.abs(nums[right])) {

                ans[index] = nums[left] * nums[left];
                left++;
            }
            else {

                ans[index] = nums[right] * nums[right];
                right--;
            }

            index--;
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna