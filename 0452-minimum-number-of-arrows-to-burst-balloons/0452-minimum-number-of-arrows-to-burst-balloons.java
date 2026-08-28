class Solution {

    public int findMinArrowShots(int[][] points) {

        Arrays.sort(points,
                (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;

        int arrow = points[0][1];

        for (int i = 1; i < points.length; i++) {

            int start = points[i][0];
            int end = points[i][1];

            if (start <= arrow) {
                continue;
            }

            arrows++;
            arrow = end;
        }

        return arrows;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna