class Solution {

    public List<List<String>> partition(String s) {

        List<List<String>> result = new ArrayList<>();

        backtrack(0, s, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(
            int index,
            String s,
            List<String> current,
            List<List<String>> result) {

        if (index == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int end = index; end < s.length(); end++) {

            if (isPalindrome(s, index, end)) {
                current.add(s.substring(index, end + 1));
                backtrack(end + 1, s, current, result);
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna