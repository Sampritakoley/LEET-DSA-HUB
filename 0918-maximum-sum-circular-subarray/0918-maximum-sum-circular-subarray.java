class Solution {

    public int maxSubarraySumCircular(int[] nums) {

        int totalSum = 0;

        int currentMax = nums[0];
        int maxSum = nums[0];

        int currentMin = nums[0];
        int minSum = nums[0];

        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];

            if (i > 0) {
                currentMax = Math.max(
                        nums[i],
                        currentMax + nums[i]
                );

                maxSum = Math.max(
                        maxSum,
                        currentMax
                );
                currentMin = Math.min(
                        nums[i],
                        currentMin + nums[i]
                );

                minSum = Math.min(
                        minSum,
                        currentMin
                );
            }
        }

        if (maxSum < 0) {
            return maxSum;
        }

        return Math.max(
                maxSum,
                totalSum - minSum
        );
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna