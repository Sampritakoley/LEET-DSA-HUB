class Solution {
   public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, "", 0, result);
        return result;
    }

    private void backtrack(String s, int index, String current, int segmentCount, List<String> result) {
        if (segmentCount == 4 && index == s.length()) {
            result.add(current.substring(0, current.length() - 1)); 
            return;
        }

        if (segmentCount >= 4 || index >= s.length()) {
            return;
        }

        for (int len = 1; len <= 3; len++) {
            if (index + len > s.length()) break;

            String part = s.substring(index, index + len);

            if (isValid(part)) {
                backtrack(s, index + len, current + part + ".", segmentCount + 1, result);
            }
        }
    }

    private boolean isValid(String segment) {
        if (segment.length() > 1 && segment.startsWith("0")) return false; 
        int num = Integer.parseInt(segment);
        return num >= 0 && num <= 255;
    }
}