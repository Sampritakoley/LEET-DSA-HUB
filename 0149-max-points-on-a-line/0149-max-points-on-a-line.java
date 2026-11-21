
import java.util.*;

class Solution {

    public int maxPoints(int[][] points) {

        int n = points.length;

        if (n <= 2) return n;

        int answer = 0;

        for (int i = 0; i < n; i++) {

            Map<String, Integer> map = new HashMap<>();

            int duplicates = 0;
            int maxCount = 0;

            for (int j = i + 1; j < n; j++) {

                long dx = (long) points[j][0] - points[i][0];
                long dy = (long) points[j][1] - points[i][1];
                if (dx == 0 && dy == 0) {
                    duplicates++;
                    continue;
                }
                if (dx == 0) {
                    dy = 1;
                }
                else if (dy == 0) {
                    dx = 1;
                }
                else {

                    long gcd = gcd(Math.abs(dx), Math.abs(dy));

                    dx /= gcd;
                    dy /= gcd;
                    if (dx < 0) {
                        dx = -dx;
                        dy = -dy;
                    }
                }

                String slope = dy + "/" + dx;

                int count = map.getOrDefault(slope, 0) + 1;

                map.put(slope, count);

                maxCount = Math.max(maxCount, count);
            }

            answer = Math.max(answer, maxCount + duplicates + 1);
        }

        return answer;
    }

    private long gcd(long a, long b) {

        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna