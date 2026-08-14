class Solution {

    public int minimizeArrayValue(int[] nums) {

        long sum = 0;
        int answer = 0;

        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];

            int required =
                (int) ((sum + i) / (i + 1));

            answer = Math.max(answer, required);
        }

        return answer;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna