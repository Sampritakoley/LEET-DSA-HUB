
class Solution {
    public String longestNiceSubstring(String s) {

        if (s.length() < 2) {
            return "";
        }
        boolean[] seen = new boolean[128];
        for (int i = 0; i < s.length(); i++) {
            seen[s.charAt(i)] = true;
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLowerCase(ch)) {
                if (!seen[Character.toUpperCase(ch)]) {
                    String left= longestNiceSubstring(s.substring(0, i));
                    String right=longestNiceSubstring(s.substring(i + 1));
                    return left.length() >= right.length() ? left : right;
                }
            } else {
                if (!seen[Character.toLowerCase(ch)]) {
                    String left = longestNiceSubstring(s.substring(0, i));
                    String right = longestNiceSubstring(s.substring(i + 1));
                    return left.length() >= right.length() ? left : right;
                }
            }
        }
        return s;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna