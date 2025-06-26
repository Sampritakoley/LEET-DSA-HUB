class Solution {
    public int longestDecomposition(String text) {
        if (text.length() == 0) return 0;  
        int n = text.length();
         
        for (int i = 1; i <= n / 2; i++) {
            String prefix = text.substring(0, i);
            String suffix = text.substring(n - i);
            System.out.println("Checking: " + prefix + " | " + suffix);

            if (prefix.equals(suffix)) {
                return 2 + longestDecomposition(text.substring(i, n - i));
            }
        }

        return 1;
    }
}