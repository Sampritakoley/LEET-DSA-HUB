class Solution {
    public String minWindow(String s, String t) {
       if (s.length() == 0 || t.length() == 0) return "";

        // Step 1: Create a hashmap for characters in t
        HashMap<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> window = new HashMap<>();
        int have = 0, needCount = need.size();
        int left = 0, minLen = Integer.MAX_VALUE;
        int resLeft = 0, resRight = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (need.containsKey(c) && window.get(c).intValue() == need.get(c).intValue()) {
                have++;
            }

            while (have == needCount) {
                if ((right - left + 1) < minLen) {
                    minLen = right - left + 1;
                    resLeft = left;
                    resRight = right;
                }

                char lChar = s.charAt(left);
                window.put(lChar, window.get(lChar) - 1);

                if (need.containsKey(lChar) && window.get(lChar).intValue() < need.get(lChar).intValue()) {
                    have--;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(resLeft, resRight + 1);
    }
}