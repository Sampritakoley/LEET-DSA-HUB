class Solution {
    public String customSortString(String order, String s) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder ans = new StringBuilder();

        for (char c : order.toCharArray()) {
            while (freq[c - 'a'] > 0) {
                ans.append(c);
                freq[c - 'a']--;
            }
        }

        for (char c = 'a'; c <= 'z'; c++) {
            while (freq[c - 'a'] > 0) {
                ans.append(c);
                freq[c - 'a']--;
            }
        }

        return ans.toString();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna