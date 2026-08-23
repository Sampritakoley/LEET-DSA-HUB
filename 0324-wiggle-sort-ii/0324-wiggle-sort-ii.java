class Solution {
    public void wiggleSort(int[] nums) {

        int n = nums.length;

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int left = (n - 1) / 2;
        int right = n - 1;
        for (int i = 0; i < n; i++) {

            if (i % 2 == 0) {
                nums[i] = sorted[left--];
            } else {
                nums[i] = sorted[right--];
            }
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna