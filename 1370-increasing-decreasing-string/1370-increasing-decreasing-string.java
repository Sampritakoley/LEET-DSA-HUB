class Solution {
    public String sortString(String s) {
        int[] count = new int[26];

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            count[ch-'a']++;
        }

        StringBuilder res = new StringBuilder();
        while(res.length()!=s.length()){
             for(int i=0;i<26;i++){
                if(count[i]>0){
                    res.append((char)(i+'a'));
                    count[i]=count[i]-1;
                }
             }

             for(int i=25;i>=0;i--){
                if(count[i]>0){
                    res.append((char)(i+'a'));
                    count[i]=count[i]-1;
                }
             }
        }
        return res.toString();
        
    }
}