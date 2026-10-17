
class Solution {
    public int longestWPI(int[] hours) {
        int score = 0;
        int maxLength = 0;

        java.util.HashMap<Integer, Integer> firstIndex = new java.util.HashMap<>();

        for (int i = 0; i < hours.length; i++) {
            if (hours[i] > 8) {
                score++;
            } else {
                score--;
            }
            if (score > 0) {
                maxLength = i + 1;
            } else {
                if (firstIndex.containsKey(score - 1)) {
                    maxLength = Math.max(
                        maxLength, i - firstIndex.get(score - 1)
                    );
                }
            }
            firstIndex.putIfAbsent(score, i);
        }

        return maxLength;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna