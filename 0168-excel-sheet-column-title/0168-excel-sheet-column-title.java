class Solution {
    public String convertToTitle(int columnNumber) {

        StringBuilder sb = new StringBuilder();

        while (columnNumber > 0) {

            columnNumber--;

            int remainder = columnNumber % 26;

            char ch = (char) ('A' + remainder);

            sb.append(ch);

            columnNumber /= 26;
        }

        return sb.reverse().toString();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna