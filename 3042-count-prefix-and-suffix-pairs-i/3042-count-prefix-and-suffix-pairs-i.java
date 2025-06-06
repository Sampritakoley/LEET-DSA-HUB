class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        int n = words.length;

        for (int i = 0; i < n; i++) {
            String prefix = words[i];
            for (int j = i + 1; j < n; j++) {
                String target = words[j];
                if (target.startsWith(prefix) && target.endsWith(prefix)) {
                    count++;
                }
            }
        }

        return count;
    }
}