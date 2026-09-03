import java.util.*;

class Solution {

    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char a = s.charAt(i);
            char b = t.charAt(i);

            if (mapST.containsKey(a)) {
                if (mapST.get(a) != b) {
                    return false;
                }
            }

            if (mapTS.containsKey(b)) {
                if (mapTS.get(b) != a) {
                    return false;
                }
            }

            mapST.put(a, b);
            mapTS.put(b, a);
        }

        return true;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna