class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }
        int[] freq = new int[26];
        for (char ch : p.toCharArray()) {
            freq[ch - 'a']++;
        }
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'a']--;
            if (right - left + 1 > p.length()) {
                freq[s.charAt(left) - 'a']++;
                left++;
            }
            if (right - left + 1 == p.length()) {
                boolean isAnagram = true;
                for (int i = 0; i < 26; i++) {
                    if (freq[i] != 0) {
                        isAnagram = false;
                        break;
                    }
                }
                if (isAnagram) {
                    result.add(left);
                }
            }
        }
        return result;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna