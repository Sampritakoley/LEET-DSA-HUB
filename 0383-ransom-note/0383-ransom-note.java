
class Solution {

    public boolean canConstruct(String ransomNote, String magazine) {

        int[] freq = new int[26];
        for (char ch : magazine.toCharArray()) {
            freq[ch - 'a']++;
        }
        for (char ch : ransomNote.toCharArray()) {
            freq[ch - 'a']--;
            if (freq[ch - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna