class Solution {
    public int myAtoi(String s) {
        int index = 0;
        int n = s.length();

        while (index < n && s.charAt(index) == ' ') index++;

        if (index >= n) return 0;

        int sign = 1;
        int res = 0;

        if (s.charAt(index) == '-' || s.charAt(index) == '+') {
            if (s.charAt(index) == '-') sign = -1;
            index++;
        }

        return convert(s, res, index, sign);
    }
     public static int convert(String s, int res, int index, int sign) {
        if (index >= s.length() || !Character.isDigit(s.charAt(index))) {
            return sign == 1 ? res : -res;
        }

        int currDigit = s.charAt(index) - '0';

        if (res > (Integer.MAX_VALUE - currDigit) / 10) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        res = res * 10 + currDigit;

        return convert(s, res, index + 1, sign);
    }
}