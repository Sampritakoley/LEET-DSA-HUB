
class Solution {

    public int[][] outerTrees(int[][] trees) {

        int n = trees.length;

        if (n <= 3) return trees;
        Arrays.sort(trees, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        List<int[]> lower = new ArrayList<>();
        for (int[] p : trees) {

            while (lower.size() >= 2 &&
                   cross(
                       lower.get(lower.size() - 2),
                       lower.get(lower.size() - 1),
                       p
                   ) < 0) {

                lower.remove(lower.size() - 1);
            }

            lower.add(p);
        }

        List<int[]> upper = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {

            int[] p = trees[i];

            while (upper.size() >= 2 &&
                   cross(
                       upper.get(upper.size() - 2),
                       upper.get(upper.size() - 1),
                       p
                   ) < 0) {

                upper.remove(upper.size() - 1);
            }

            upper.add(p);
        }
        Set<String> seen = new HashSet<>();

        List<int[]> result = new ArrayList<>();

        for (int[] p : lower) {
            String key = p[0] + "," + p[1];

            if (seen.add(key)) {
                result.add(p);
            }
        }

        for (int[] p : upper) {
            String key = p[0] + "," + p[1];

            if (seen.add(key)) {
                result.add(p);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
    private long cross(int[] a, int[] b, int[] c) {

        long abX = b[0] - a[0];
        long abY = b[1] - a[1];

        long bcX = c[0] - b[0];
        long bcY = c[1] - b[1];

        return abX * bcY - abY * bcX;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna