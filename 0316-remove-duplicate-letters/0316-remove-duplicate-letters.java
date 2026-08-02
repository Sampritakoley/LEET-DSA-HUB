class Solution {
    public String removeDuplicateLetters(String s) {

        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        Stack<Character> stack = new Stack<>();
        boolean[] used = new boolean[26];

        for (int i = 0; i < s.length(); i++) {

            char current = s.charAt(i);
            int idx = current - 'a';
            if (used[idx]) {
                continue;
            }
            while (!stack.isEmpty()
                    && stack.peek() > current
                    && last[stack.peek() - 'a'] > i) {

                char removed = stack.pop();
                used[removed - 'a'] = false;
            }

            stack.push(current);
            used[idx] = true;
        }

        StringBuilder result = new StringBuilder();

        for (char c : stack) {
            result.append(c);
        }

        return result.toString();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna