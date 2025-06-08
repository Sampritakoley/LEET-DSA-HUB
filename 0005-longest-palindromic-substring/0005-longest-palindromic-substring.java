class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dp=new boolean[s.length()][s.length()];
        String longestStr="";

        for(int g=0;g<s.length();g++){
            for(int i=0,j=g;j<s.length() && i<s.length();i++,j++){
                if(g==0){
                   dp[i][j]=true;
                   String str=s.substring(i, j+1);
                   longestStr=longestStr.length()<str.length()?str:longestStr;
                }else if(g==1){
                    if(s.charAt(i)==s.charAt(j)){
                       dp[i][j]=true;
                       String str=s.substring(i, j+1);
                       longestStr=longestStr.length()<str.length()?str:longestStr;
                    }
                }else{
                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]){
                        dp[i][j]=true;
                       String str=s.substring(i, j+1);
                       longestStr=longestStr.length()<str.length()?str:longestStr;
                    }
                }
            }
        }
        return longestStr;
    }
}