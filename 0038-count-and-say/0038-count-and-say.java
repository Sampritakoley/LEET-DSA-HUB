class Solution {

    public String countAndSay(int n) {

        String result = "1";

        for (int i = 2; i <= n; i++) {

            StringBuilder next = new StringBuilder();

            int count = 1;

            for (int j = 1; j <= result.length(); j++) {

                if (j < result.length() &&
                    result.charAt(j) == result.charAt(j - 1)) {

                    count++;

                } else {

                    next.append(count);
                    next.append(result.charAt(j - 1));

                    count = 1;
                }
            }

            result = next.toString();
        }

        return result;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna