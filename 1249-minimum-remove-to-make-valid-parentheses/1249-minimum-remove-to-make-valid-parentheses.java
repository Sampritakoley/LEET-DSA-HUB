class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder result = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            }
            else if (ch == ')') {

                if (stack.isEmpty()) {
                    result.setCharAt(i, '*');
                }
                else {
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) {
            result.setCharAt(stack.pop(), '*');
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) != '*') {
                ans.append(result.charAt(i));
            }
        }
        return ans.toString();
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna