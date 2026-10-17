
class Solution {
    public int minOperations(String[] logs) {

        int depth = 0;

        for (String log : logs) {

            if (log.equals("../")) {
                if (depth > 0) {
                    depth--;
                }
            }
            else if (log.equals("./")) {
                continue;
            }
            else {
                depth++;
            }
        }

        return depth;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna