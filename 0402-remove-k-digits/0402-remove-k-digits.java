class Solution {
    public String removeKdigits(String num, int k) {

        Stack<Character> stack = new Stack<>();

        for (char digit : num.toCharArray()) {

            while (!stack.isEmpty()
                    && k > 0
                    && stack.peek() > digit) {

                stack.pop();
                k--;
            }

            stack.push(digit);
        }
        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder result = new StringBuilder();

        for (char digit : stack) {
            result.append(digit);
        }

        int i = 0;

        while (i < result.length()
                && result.charAt(i) == '0') {
            i++;
        }

        result = new StringBuilder(
            result.substring(i)
        );

        return result.length() == 0
                ? "0"
                : result.toString();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna