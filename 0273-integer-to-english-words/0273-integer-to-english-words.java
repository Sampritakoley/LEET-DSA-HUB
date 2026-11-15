
class Solution {

    private final String[] belowTwenty = {
        "", "One", "Two", "Three", "Four",
        "Five", "Six", "Seven", "Eight", "Nine",
        "Ten", "Eleven", "Twelve", "Thirteen",
        "Fourteen", "Fifteen", "Sixteen",
        "Seventeen", "Eighteen", "Nineteen"
    };

    private final String[] tens = {
        "", "", "Twenty", "Thirty", "Forty",
        "Fifty", "Sixty", "Seventy", "Eighty",
        "Ninety"
    };

    private final String[] thousands = {
        "", "Thousand", "Million", "Billion"
    };

    public String numberToWords(int num) {

        if (num == 0) {
            return "Zero";
        }

        StringBuilder result = new StringBuilder();

        int group = 0;

        while (num > 0) {

            int chunk = num % 1000;

            if (chunk != 0) {
                String words = convert(chunk);
                result.insert(0,words + " " + thousands[group] + " ");
            }

            num /= 1000;
            group++;
        }

        return result.toString().trim().replaceAll("\\s+", " ");
    }

    private String convert(int num) {

        if (num == 0) {
            return "";
        }

        if (num < 20) {
            return belowTwenty[num];
        }

        if (num < 100) {
            return tens[num / 10] + " " +convert(num % 10);
        }

        return belowTwenty[num / 100] +" Hundred " +convert(num % 100);
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna