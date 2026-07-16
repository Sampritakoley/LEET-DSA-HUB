class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        int front = Math.max(minIndex, maxIndex) + 1;
        int back = n - Math.min(minIndex, maxIndex);
        int frontBack = (minIndex + 1) + (n - maxIndex);
        int backFront = (maxIndex + 1) + (n - minIndex);

        return Math.min(Math.min(front, back), Math.min(frontBack, backFront));
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna