class Solution {
    public String answerString(String word, int numFriends) {
        int n = word.length();
        if (numFriends == 1) return word;

        int maxLength = n - numFriends + 1;

        // Build suffix array (sort indices by suffix lex order)
        Integer[] suffixes = new Integer[n];
        for (int i = 0; i < n; i++) suffixes[i] = i;

        Arrays.sort(suffixes, (a, b) -> {
            int len = Math.min(n - a, n - b);
            for (int i = 0; i < len; i++) {
                if (word.charAt(a + i) != word.charAt(b + i))
                    return word.charAt(b + i) - word.charAt(a + i); // Desc order
            }
            return (n - b) - (n - a); // longer suffix comes first
        });

        String maxStr = "";
        for (int start : suffixes) {
            int length = Math.min(maxLength, n - start);
            String candidate = word.substring(start, start + length);
            if (candidate.compareTo(maxStr) > 0) {
                maxStr = candidate;
            }
        }
        return maxStr;
    }
}