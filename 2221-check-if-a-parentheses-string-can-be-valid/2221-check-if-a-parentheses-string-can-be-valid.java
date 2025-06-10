class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if (n % 2 != 0) return false;

        int open = 0;
        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '1') {
                open += (s.charAt(i) == '(') ? 1 : -1;
            } else {
                open += 1; 
            }
            if (open < 0) return false; 
        }

        int close = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (locked.charAt(i) == '1') {
                close += (s.charAt(i) == ')') ? 1 : -1;
            } else {
                close += 1;
            }
            if (close < 0) return false; 
        }

        return true;
    }
}