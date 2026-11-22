
class Solution {
    public int visiblePoints(
        List<List<Integer>> points,
        int angle,
        List<Integer> location
    ) {

        int x = location.get(0);
        int y = location.get(1);

        List<Double> angles = new ArrayList<>();

        int sameLocation = 0;
        for (List<Integer> point : points) {

            int dx = point.get(0) - x;
            int dy = point.get(1) - y;
            if (dx == 0 && dy == 0) {
                sameLocation++;
                continue;
            }

            double theta = Math.toDegrees(
                Math.atan2(dy, dx)
            );

            if (theta < 0) {
                theta += 360;
            }

            angles.add(theta);
        }
        Collections.sort(angles);

        int n = angles.size();
        List<Double> extended = new ArrayList<>(angles);

        for (double a : angles) {
            extended.add(a + 360);
        }
        int left = 0;
        int maxVisible = 0;

        for (int right = 0; right < extended.size(); right++) {

            while (
                extended.get(right) - extended.get(left)
                > angle + 1e-9
            ) {
                left++;
            }

            maxVisible = Math.max(
                maxVisible,
                right - left + 1
            );
        }

        return maxVisible + sameLocation;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna