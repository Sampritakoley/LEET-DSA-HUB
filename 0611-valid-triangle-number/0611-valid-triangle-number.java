class Solution {
    public int triangleNumber(int[] nums) {

        Arrays.sort(nums);

        int n = nums.length;
        int count = 0;

        for (int k = n - 1; k >= 2; k--) {

            int left = 0;
            int right = k - 1;

            while (left < right) {

                if (nums[left] + nums[right] > nums[k]) {

                    count += right - left;

                    right--;

                } else {

                    left++;
                }
            }
        }

        return count;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna