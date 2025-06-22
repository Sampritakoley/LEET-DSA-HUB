class Solution {
    public String[] divideString(String s, int k, char fill) {
         int n = s.length();
        int groups = (n + k - 1) / k;  
        String[] result = new String[groups];

        int index = 0;
        for (int i = 0; i < groups; i++) {
            int end = Math.min(index + k, n);
            String part = s.substring(index, end);
            if (part.length() < k) {
                StringBuilder sb = new StringBuilder(part);
                while (sb.length() < k) {
                    sb.append(fill);
                }
                part = sb.toString();
            }
            result[i] = part;
            index += k;
        }

        return result;
    }
}