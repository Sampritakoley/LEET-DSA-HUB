import java.util.*;

public class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            index.put(arr[i], i);
        }

        int[][] dp = new int[n][n];
        int maxLen = 0;

        for (int k = 0; k < n; ++k) {
            for (int j = 0; j < k; ++j) {
                int iVal = arr[k] - arr[j];
                if (iVal >= arr[j]) continue; // Ensure strictly increasing
                Integer i = index.get(iVal);
                if (i != null) {
                    dp[j][k] = dp[i][j] > 0 ? dp[i][j] + 1 : 3;
                    maxLen = Math.max(maxLen, dp[j][k]);
                }
            }
        }

        return maxLen;
    }
}
