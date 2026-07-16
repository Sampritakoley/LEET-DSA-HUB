class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        ArrayList<Integer> list = new ArrayList<>();

        int carry = 1;

        for (int i = n - 1; i >= 0; i--) {
            int sum = digits[i] + carry;

            list.add(0, sum % 10);
            carry = sum / 10;
        }

        if (carry != 0) {
            list.add(0, carry);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna