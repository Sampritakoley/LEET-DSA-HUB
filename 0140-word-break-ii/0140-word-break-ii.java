class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> dict = new HashSet<>(wordDict);

        List<Integer>[] dp = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) dp[i] = new ArrayList<>();

        dp[0].add(0); 

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (!dp[j].isEmpty() && dict.contains(s.substring(j, i))) {
                    dp[i].add(j); 
                }
            }
        }

        List<String> result = new ArrayList<>();
        if (dp[n].isEmpty()) return result; 

        backtrack(s, dp, n, new ArrayList<>(), result);
        return result;
    }
   private void backtrack(String s, List<Integer>[] dp, int index,
                           List<String> path, List<String> result) {

        if (index == 0) {
            Collections.reverse(path);
            result.add(String.join(" ", path));
            Collections.reverse(path);
            return;
        }

        for (int start : dp[index]) {
            String word = s.substring(start, index);
            path.add(word);
            backtrack(s, dp, start, path, result);
            path.remove(path.size() - 1);
        }
    }
}