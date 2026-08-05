class Solution {

    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        Set<String> set = new HashSet<>();

        for (String word : words) {
            set.add(word);
        }

        List<String> result = new ArrayList<>();

        for (String word : words) {

            set.remove(word);

            if (canForm(word, set)) {
                result.add(word);
            }

            set.add(word);
        }

        return result;
    }

    private boolean canForm(String word, Set<String> set) {

        int n = word.length();

        boolean[] dp = new boolean[n + 1];

        dp[0] = true;

        for (int i = 0; i < n; i++) {

            if (!dp[i]) {
                continue;
            }

            for (int j = i + 1; j <= n; j++) {

                String part = word.substring(i, j);

                if (set.contains(part)) {
                    dp[j] = true;
                }
            }
        }

        return dp[n];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna