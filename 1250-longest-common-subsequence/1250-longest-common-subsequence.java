class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp=new int[text1.length()][text2.length()];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i==0 && j==0){
                  if(text1.charAt(i)==text2.charAt(j)){
                    dp[i][j]=1;
                  }else{
                    dp[i][j]=0;
                  }
                }
                else if(i==0){
                  if(text1.charAt(i)==text2.charAt(j)){
                    dp[i][j]=1;
                  }else{
                    dp[i][j]=dp[i][j-1];
                  }
                }else if (j==0){
                    if(text1.charAt(i)==text2.charAt(j)){
                    dp[i][j]=1;
                  }else{
                    dp[i][j]=dp[i-1][j];
                  }
                }else{
                  if(text1.charAt(i)==text2.charAt(j)){
                    dp[i][j]=dp[i-1][j-1]+1;
                  }else{
                    dp[i][j]=Math.max(Math.max(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]);
                  }
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}