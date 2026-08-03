class Solution {
    public boolean find132pattern(int[] nums) {

        Stack<Integer> stack = new Stack<>();

        int second = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {

            if (nums[i] < second) {
                return true;
            }

            while (!stack.isEmpty()
                    && nums[i] > stack.peek()) {

                second = stack.pop();
            }

            stack.push(nums[i]);
        }

        return false;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna