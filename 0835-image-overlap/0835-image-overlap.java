class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        List<int[]> ones1 = new ArrayList<>();
        List<int[]> ones2 = new ArrayList<>();

        int n = img1.length;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (img1[r][c] == 1) {
                    ones1.add(new int[]{r, c});
                }

                if (img2[r][c] == 1) {
                    ones2.add(new int[]{r, c});
                }
            }
        }

        Map<String, Integer> count = new HashMap<>();

        int answer = 0;

        for (int[] p1 : ones1) {
            for (int[] p2 : ones2) {

                int dr = p1[0] - p2[0];
                int dc = p1[1] - p2[1];

                String key = dr + "," + dc;

                int freq = count.getOrDefault(key, 0) + 1;

                count.put(key, freq);

                answer = Math.max(answer, freq);
            }
        }

        return answer;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna