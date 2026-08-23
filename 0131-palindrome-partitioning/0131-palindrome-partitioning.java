class Solution {

    public List<List<String>> partition(String s) {
        return getPartitions(s);
    }

    private List<List<String>> getPartitions(String str) {

        if (str.length() == 0) {

            List<List<String>> base = new ArrayList<>();

            base.add(new ArrayList<>());

            return base;
        }

        List<List<String>> result = new ArrayList<>();

        for (int cut = 1; cut <= str.length(); cut++) {

            String prefix = str.substring(0, cut);

            if (isPalindrome(prefix)) {

                String remaining = str.substring(cut);
                List<List<String>> recursiveResult =
                        getPartitions(remaining);

                for (List<String> partition : recursiveResult) {

                    List<String> newPartition =
                            new ArrayList<>();

                    newPartition.add(prefix);
                    newPartition.addAll(partition);

                    result.add(newPartition);
                }
            }
        }

        return result;
    }

    private boolean isPalindrome(String str) {

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {

            if (str.charAt(left) != str.charAt(right)) {
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