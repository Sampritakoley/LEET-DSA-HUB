class Solution {
    public int earliestFinishTime(int[] landStartTime,int[] landDuration,int[] waterStartTime,int[] waterDuration) {
        int n = landStartTime.length;
        int m = waterStartTime.length;
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int landFinish =landStartTime[i] + landDuration[i];
            for (int j = 0; j < m; j++) {
                int waterStart = Math.max(landFinish,waterStartTime[j]);
                int finish =waterStart + waterDuration[j];
                answer = Math.min(answer, finish);
            }
        }
        for (int j = 0; j < m; j++) {
            int waterFinish =waterStartTime[j] + waterDuration[j];
            for (int i = 0; i < n; i++) {
                int landStart = Math.max(waterFinish,landStartTime[i]);
                int finish =landStart + landDuration[i];
                answer = Math.min(answer, finish);
            }
        }
        return answer;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna