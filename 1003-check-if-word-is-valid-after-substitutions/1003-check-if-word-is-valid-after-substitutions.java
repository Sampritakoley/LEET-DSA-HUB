
class Solution {
    public boolean isValid(String s) {

        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (ch == 'c') {

                if (st.size() < 2) {
                    return false;
                }

                char b = st.pop();
                char a = st.pop();

                if (a != 'a' || b != 'b') {
                    return false;
                }

            } else {
                st.push(ch);
            }
        }

        return st.isEmpty();
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna