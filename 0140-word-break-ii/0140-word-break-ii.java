class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set=new HashSet<>(wordDict);
        ArrayList<String>[] dp=new ArrayList[s.length()+1];
        dp[0]=new ArrayList<>();
        dp[0].add("");
        for(int i=1;i<s.length()+1;i++){
            dp[i]=new ArrayList<>();
            for(int j=i-1;j>=0;j--){
                String str=s.substring(j,i);
                if(set.contains(str)){
                    ArrayList<String> lst=dp[j];
                    if(lst.size()==0){
                        continue;
                    }
                    for(String prev:lst){
                        if(prev.isEmpty()){
                           dp[i].add(str);   
                        }else{
                           dp[i].add(prev+" "+str);
                        }
                    }
                }
            }
        }
        return dp[s.length()];
    }
}