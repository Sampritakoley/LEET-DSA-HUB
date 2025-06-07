class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
         int[] maxFreq = new int[26];

        for (String word : words2) {
            int[] freq = countFreq(word);
            for (int i = 0; i < 26; i++) {
                maxFreq[i] = Math.max(maxFreq[i], freq[i]);
            }
        }

        List<String> result = new ArrayList<>();

        for (String word : words1) {
            int[] wordFreq = countFreq(word);
            boolean isUniversal = true;

            for (int i = 0; i < 26; i++) {
                if (wordFreq[i] < maxFreq[i]) {
                    isUniversal = false;
                    break;
                }
            }

            if (isUniversal) {
                result.add(word);
            }
        }

        return result;
    }

    private static int[] countFreq(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }
}