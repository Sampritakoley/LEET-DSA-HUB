class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int originalColor = image[sr][sc];
        if (originalColor == color) {
            return image;
        }

        dfs(image, sr, sc, originalColor, color);

        return image;
    }

    private void dfs(
            int[][] image,
            int r,
            int c,
            int originalColor,
            int newColor) {

        int m = image.length;
        int n = image[0].length;
        if (r < 0 || r >= m || c < 0 || c >= n) {
            return;
        }
        if (image[r][c] != originalColor) {
            return;
        }
        image[r][c] = newColor;
        dfs(image, r - 1, c, originalColor, newColor); // up
        dfs(image, r + 1, c, originalColor, newColor); // down
        dfs(image, r, c - 1, originalColor, newColor); // left
        dfs(image, r, c + 1, originalColor, newColor); // right
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna