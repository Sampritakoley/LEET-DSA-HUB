class Solution {
    public int minCut(String s) {
        boolean[][] dp=new boolean[s.length()][s.length()];
        for(int g=0;g<s.length();g++){
            for(int i=0,j=g;i<s.length() && j<s.length();i++,j++){
                if(g==0){
                    dp[i][j]=true;
                }else if(g==1){
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j]=true;
                    }else{
                        dp[i][j]=false;
                    }
                }else{
                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]){
                        dp[i][j]=true;
                    }else{
                       dp[i][j]=false; 
                    }
                }
            }
        }
        int[] st=new int[s.length()];
        st[0]=0;
        for(int j=1;j<s.length();j++){
            if(dp[0][j]){
                st[j] = 0; 
            }else{
                int min=Integer.MAX_VALUE;
            for(int i=j;i>=1;i--){
                    if(dp[i][j]){
                      min=Math.min(st[i-1],min);
                    }
                }
                st[j]=min+1;
            }
            
        }
        return st[s.length()-1];
    }
}