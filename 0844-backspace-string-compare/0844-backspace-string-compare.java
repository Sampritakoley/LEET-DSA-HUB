class Solution {
    public boolean backspaceCompare(String s, String t) {

        Stack<Character> stack1 = build(s);
        Stack<Character> stack2 = build(t);

        return stack1.equals(stack2);
    }

    private Stack<Character> build(String s) {

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (ch == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }
        }

        return stack;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna