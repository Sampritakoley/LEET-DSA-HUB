import java.util.*;

class Solution {

    private Set<String> dict;
    private String s;
    private Map<Integer, List<String>> memo;

    public List<String> wordBreak(String s, List<String> wordDict) {

        this.s = s;
        this.dict = new HashSet<>(wordDict);
        this.memo = new HashMap<>();

        return dfs(0);
    }

    private List<String> dfs(int start) {

        if (start == s.length()) {
            return List.of("");
        }

        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        List<String> result = new ArrayList<>();

        for (int end = start + 1; end <= s.length(); end++) {

            String word = s.substring(start, end);

            if (!dict.contains(word)) {
                continue;
            }

            List<String> suffixSentences = dfs(end);

            for (String suffix : suffixSentences) {

                if (suffix.isEmpty()) {
                    result.add(word);
                } else {
                    result.add(word + " " + suffix);
                }
            }
        }

        memo.put(start, result);

        return result;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna