class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp=new boolean[s.length()+1];
        int n=s.length()+1;
        dp[0]=true;
        for(int i=1;i<n;i++){
            for(int j=i-1;j>=0;j--){
                String str=s.substring(j,i);
                if(set.contains(str)){
                    if(dp[j]){
                        dp[i]=true;
                        break;
                    }
                }
            }
        }
        return dp[s.length()];
    }
}