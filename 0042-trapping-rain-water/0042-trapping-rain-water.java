class Solution {
    public int trap(int[] height) {

        Stack<Integer> stack = new Stack<>();

        int water = 0;

        for (int i = 0; i < height.length; i++) {

            while (!stack.isEmpty()
                    && height[i] > height[stack.peek()]) {

                int middle = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }

                int left = stack.peek();

                int width = i - left - 1;

                int waterHeight =
                    Math.min(height[left], height[i])
                    - height[middle];

                water += width * waterHeight;
            }

            stack.push(i);
        }

        return water;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna