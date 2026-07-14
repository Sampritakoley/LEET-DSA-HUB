class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->{
                    if(a[0]==b[0])
                    return a[1]-b[1];
                  return a[0]-b[0];
        });
        int n=pairs.length;
        int[] dp=new int[pairs.length];
        dp[0]=1;int max=1;
        for(int i=0;i<n;i++){
            int j=i-1; dp[i]=1;
            while(j>=0){
                if(pairs[i][0] > pairs[j][1]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
                j--;
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna