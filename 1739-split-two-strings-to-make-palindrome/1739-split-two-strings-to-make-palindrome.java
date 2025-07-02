class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        return check(a, b) || check(b, a);
    }

    private boolean check(String s1, String s2) {
        int i = 0, j = s1.length() - 1;
        while (i < j && s1.charAt(i) == s2.charAt(j)) {
            i++;
            j--;
        }
        return isPalindrome(s1, i, j) || isPalindrome(s2, i, j);
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}