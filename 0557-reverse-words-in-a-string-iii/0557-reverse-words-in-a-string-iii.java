class Solution {
    public String reverseWords(String s) {

        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {

            StringBuilder word = new StringBuilder(words[i]);
            result.append(word.reverse());

            if (i != words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna