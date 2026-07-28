class Solution {
    public int findCenter(int[][] edges) {

        int a = edges[0][0];
        int b = edges[0][1];

        if (a == edges[1][0] || a == edges[1][1])
            return a;

        return b;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna