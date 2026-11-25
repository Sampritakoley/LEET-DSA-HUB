class Solution {
    public int maxActiveSectionsAfterTrade(String s) {

        String t = "1" + s + "1";

        int n = t.length();

        List<Integer> groups = new ArrayList<>();
        List<Character> chars = new ArrayList<>();

        int count = 1;

        for (int i = 1; i < n; i++) {
            if (t.charAt(i) == t.charAt(i - 1)) {
                count++;
            } else {
                groups.add(count);
                chars.add(t.charAt(i - 1));
                count = 1;
            }
        }

        groups.add(count);
        chars.add(t.charAt(n - 1));

        int originalOnes = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                originalOnes++;
            }
        }

        int ans = originalOnes;

        for (int i = 1; i + 2 < groups.size(); i++) {

            if (chars.get(i) == '1'&& chars.get(i - 1) == '0'&& chars.get(i + 1) == '0') {

                int sacrificed = groups.get(i);

                int mergedZeros = groups.get(i - 1)+ sacrificed+ groups.get(i + 1);

                int candidate = originalOnes - sacrificed+ mergedZeros;

                ans = Math.max(ans, candidate);
            }
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna