class Solution {

    public int numMatchingSubseq(String s, String[] words) {

        List<Integer>[] positions = new ArrayList[26];

        for (int i = 0; i < 26; i++) {
            positions[i] = new ArrayList<>();
        }
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            positions[c - 'a'].add(i);
        }

        int count = 0;

        for (String word : words) {

            if (isSubsequence(word, positions)) {
                count++;
            }
        }

        return count;
    }

    private boolean isSubsequence(
            String word,
            List<Integer>[] positions) {

        int previousIndex = -1;

        for (char c : word.toCharArray()) {

            List<Integer> list = positions[c - 'a'];

            int index = upperBound(list, previousIndex);

            if (index == list.size()) {
                return false;
            }

            previousIndex = list.get(index);
        }

        return true;
    }

    private int upperBound(
            List<Integer> list,
            int target) {

        int left = 0;
        int right = list.size();

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (list.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna