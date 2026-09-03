import java.util.*;

class Solution {
    public List<String> commonChars(String[] words) {
        int[] common = new int[26];
        Arrays.fill(common, Integer.MAX_VALUE);

        for (String word : words) {
            int[] freq = new int[26];

            for (char ch : word.toCharArray()) {
                freq[ch - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                common[i] = Math.min(common[i], freq[i]);
            }
        }

        List<String> result = new ArrayList<>();

        for (int i = 0; i < 26; i++) {

            for (int count = 0; count < common[i]; count++) {
                result.add(String.valueOf((char) ('a' + i)));
            }
        }

        return result;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna