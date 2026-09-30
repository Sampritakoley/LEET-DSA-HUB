class Solution {
    public int[] maxDepthAfterSplit(String seq) {

        int[] answer = new int[seq.length()];
        int depth = 0;

        for (int i = 0; i < seq.length(); i++) {

            char ch = seq.charAt(i);

            if (ch == '(') {
                depth++;
                answer[i] = depth % 2;
            } 
            else {
                answer[i] = depth % 2;

                depth--;
            }
        }

        return answer;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna