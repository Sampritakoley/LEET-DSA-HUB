class Solution {
    public int[] finalPrices(int[] prices) {

        int n = prices.length;

        Stack<Integer> stack = new Stack<>();

        int[] ans = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() > prices[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ans[i] = prices[i] - stack.peek();
            } else {
                ans[i] = prices[i];
            }
            stack.push(prices[i]);
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna