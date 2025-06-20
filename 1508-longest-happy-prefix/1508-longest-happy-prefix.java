class Solution {
    public String longestPrefix(String s) {
        int[] lps=new int[s.length()];
        int len=0;
        int i=1;

        while(i<s.length()){
            if(s.charAt(len)==s.charAt(i)){
                len++;
                lps[i]=len;
                i++;
            }else{
                if(len==0){
                  lps[i]=0;
                  i++;
                }else{
                    len=lps[len-1];
                }
            }
        }
        return s.substring(0, len);
    }
}