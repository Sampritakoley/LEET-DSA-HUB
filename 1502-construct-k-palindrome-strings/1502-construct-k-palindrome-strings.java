class Solution {
    public boolean canConstruct(String s, int k) {
        if (s.length() < k) return false;

    int[] freq = new int[26];
    for (char c : s.toCharArray()) {
        freq[c - 'a']++;
    }

    int oddCount = 0;
    for (int f : freq) {
        if (f % 2 != 0) oddCount++;
    }

    return oddCount <= k;
    }
}