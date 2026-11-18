
class Solution {
    public int kthGrammar(int n, int k) {

        if (n == 1) {
            return 0;
        }

        int mid = 1 << (n - 2);

        if (k <= mid) {
            return kthGrammar(n - 1, k);
        }

        return 1 - kthGrammar(n - 1, k - mid);
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna