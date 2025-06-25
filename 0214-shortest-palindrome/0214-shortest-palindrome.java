class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        String rev=new StringBuilder(s).reverse().toString();
        String mix=s+'#'+rev;
        int[] lps=new int[mix.length()];
        int i=1;
        int len=0;
        lps[0]=0;
        while(i<mix.length()){
            if(mix.charAt(len)==mix.charAt(i)){
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
        int maxLen=lps[mix.length()-1];
        String suffix = s.substring(maxLen);
        String prefix = new StringBuilder(suffix).reverse().toString();

        return prefix + s;
    }
}