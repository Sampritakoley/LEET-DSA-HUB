class Solution {
    public int maxDifference(String s) {
        int[] freq = new int[26];
        
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int maxDiff = Integer.MIN_VALUE;

        List<Integer> oddFreqs = new ArrayList<>();
        List<Integer> evenFreqs = new ArrayList<>();

        for (int f : freq) {
            if (f > 0) {
                if (f % 2 == 0) {
                    evenFreqs.add(f);
                } else {
                    oddFreqs.add(f);
                }
            }
        }

        if (oddFreqs.isEmpty() || evenFreqs.isEmpty()) {
            return 0;
        }

        for (int odd : oddFreqs) {
            for (int even : evenFreqs) {
                maxDiff = Math.max(maxDiff, odd - even);
            }
        }

        return maxDiff;
    }
}