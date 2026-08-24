class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;

        int[] answer = new int[n];

        int prefix = 1;

        for (int i = 0; i < n; i++) {

            answer[i] = prefix;

            prefix *= nums[i];
        }

        int suffix = 1;

        for (int i = n - 1; i >= 0; i--) {

            answer[i] *= suffix;

            suffix *= nums[i];
        }

        return answer;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna