
import java.util.*;

class Solution {
    public int minOperations(String[] logs) {

        Stack<String> st = new Stack<>();

        for (String log : logs) {

            if (log.equals("../")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            }
            else if (log.equals("./")) {
                continue;
            }
            else {
                st.push(log);
            }
        }

        return st.size();
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna