class Solution {

    public boolean canMeasureWater(int x, int y, int target) {

        if (target > x + y) {
            return false;
        }

        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(new int[]{0, 0});

        while (!queue.isEmpty()) {

            int[] curr = queue.poll();

            int a = curr[0];
            int b = curr[1];

            if (a == target || b == target || a + b == target) {
                return true;
            }

            String key = a + "," + b;

            if (visited.contains(key)) {
                continue;
            }

            visited.add(key);
            queue.offer(new int[]{x, b});
            queue.offer(new int[]{a, y});
            queue.offer(new int[]{0, b});
            queue.offer(new int[]{a, 0});
            int pour = Math.min(a, y - b);
            queue.offer(new int[]{a - pour, b + pour});
            pour = Math.min(b, x - a);
            queue.offer(new int[]{a + pour, b - pour});
        }

        return false;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna