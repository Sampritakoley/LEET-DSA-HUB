class Solution {
    public int maximumSwap(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        int[] last = new int[10];
        for (int i = 0; i < arr.length; i++) {
            int digit = arr[i] - '0';
            last[digit] = i;
        }
        for (int i = 0; i < arr.length; i++) {
            int currentDigit = arr[i] - '0';
            for (int d = 9; d > currentDigit; d--) {
                if (last[d] > i) {
                    char temp = arr[i];
                    arr[i] = arr[last[d]];
                    arr[last[d]] = temp;

                    return Integer.parseInt(new String(arr));
                }
            }
        }
        return num;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna