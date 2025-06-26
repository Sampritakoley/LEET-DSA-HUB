class Solution {
    public boolean validPalindrome(String s) {
        int l=0;
        int r=s.length()-1;

        while(l<r){
            if(s.charAt(l)==s.charAt(r)){
                l++;
                r--;
            }else{
                return (isPalindrome(s.substring(l,r)) || isPalindrome(s.substring(l+1,r+1)));
            }
        }
        return true;
    }
    private static boolean isPalindrome(String s) {
        int l=0;
        int r=s.length()-1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }

}