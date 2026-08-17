import java.util.*;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        int n = s.length();
        
        Set<String> set = new HashSet<>(wordDict);
        
        boolean[] dp = new boolean[n + 1];
        
        dp[0] = true;
        
        for (int i = 1; i <= n; i++) {
            
            for (int j = 0; j < i; j++) {
                
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[n];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna