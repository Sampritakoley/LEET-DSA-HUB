class Solution {
    public int countSubstrings(String s) {
        boolean[][] dp=new boolean[s.length()][s.length()];
        int count=0;
        for(int g=0;g<s.length();g++){
           for(int i=0,j=g;i<s.length() && j<s.length();i++,j++){
              if(g==0){
                dp[i][j]=true;
                count++;
              }else if(g==1){
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j]=true;
                    count++;
                }else{
                    dp[i][j]=false;
                }
              }else{
                if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==true){
                    dp[i][j]=true;
                    count++;
                }else{
                    dp[i][j]=false;
                }
              }
           }
        }
        return count;
    }
}