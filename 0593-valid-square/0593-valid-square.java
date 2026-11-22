
class Solution {

    private int distance(int[] a, int[] b) {
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];

        return dx * dx + dy * dy;
    }

    public boolean validSquare(int[] p1, int[] p2,
                               int[] p3, int[] p4) {

        int[][] points = {p1, p2, p3, p4};

        Set<Integer> distances = new HashSet<>();

        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                distances.add(distance(points[i], points[j]));
            }
        }

        if (distances.contains(0) || distances.size() != 2) {
            return false;
        }

        int min = Collections.min(distances);
        int max = Collections.max(distances);

        return max == 2 * min;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna