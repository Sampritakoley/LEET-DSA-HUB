class Solution {
    public int calculate(String s) {

        Stack<Integer> stack = new Stack<>();

        int number = 0;
        char sign = '+';

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            }

            if ((!Character.isDigit(ch) && ch != ' ') 
                    || i == s.length() - 1) {

                switch (sign) {

                    case '+':
                        stack.push(number);
                        break;

                    case '-':
                        stack.push(-number);
                        break;

                    case '*':
                        stack.push(stack.pop() * number);
                        break;

                    case '/':
                        stack.push(stack.pop() / number);
                        break;
                }

                sign = ch;
                number = 0;
            }
        }

        int result = 0;

        for (int value : stack) {
            result += value;
        }

        return result;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna