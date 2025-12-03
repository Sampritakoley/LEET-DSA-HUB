class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;
        for(int i=0;i<s.length();i++){
            int left=i;
            while(left>=0){
                String str=s.substring(left,i+1);
                if(wordDict.contains(str) && dp[left]){
                   dp[i+1]=true;
                }
                left--;
            }
        }
        return dp[s.length()];
    }
}