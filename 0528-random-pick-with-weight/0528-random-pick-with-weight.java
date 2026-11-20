
class Solution {
    int[] prefix;
    int total;
    Random random;
    public Solution(int[] w) {
        int n = w.length;
        prefix = new int[n];
        random = new Random();
        prefix[0] = w[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + w[i];
        }
        total = prefix[n - 1];
    }
    public int pickIndex() {
        int target = random.nextInt(total) + 1;
        int left = 0;
        int right = prefix.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (prefix[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna