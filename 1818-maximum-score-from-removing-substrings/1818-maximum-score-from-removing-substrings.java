public class Solution {
    public int maximumGain(String s, int x, int y) {
        if (x > y) {
            return getPoints(s, "ab", x, "ba", y);
        } else {
            return getPoints(s, "ba", y, "ab", x);
        }
    }

    private int getPoints(String s, String first, int firstVal, String second, int secondVal) {
        int points = 0;

        // Step 1: Remove first preferred substring
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            sb.append(ch);
            if (sb.length() >= 2 && sb.charAt(sb.length() - 2) == first.charAt(0) && sb.charAt(sb.length() - 1) == first.charAt(1)) {
                sb.delete(sb.length() - 2, sb.length());
                points += firstVal;
            }
        }

        // Step 2: Remove second preferred substring
        StringBuilder finalStr = new StringBuilder();
        for (char ch : sb.toString().toCharArray()) {
            finalStr.append(ch);
            if (finalStr.length() >= 2 && finalStr.charAt(finalStr.length() - 2) == second.charAt(0) && finalStr.charAt(finalStr.length() - 1) == second.charAt(1)) {
                finalStr.delete(finalStr.length() - 2, finalStr.length());
                points += secondVal;
            }
        }

        return points;
    }
}
