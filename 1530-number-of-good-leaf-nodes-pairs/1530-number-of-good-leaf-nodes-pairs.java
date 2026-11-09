class Solution {

    int count = 0;

    public int countPairs(TreeNode root, int distance) {

        dfs(root, distance);
        return count;
    }

    private List<Integer> dfs(TreeNode root, int distance) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        if (root.left == null && root.right == null) {
            result.add(1);
            return result;
        }
        List<Integer> left = dfs(root.left, distance);
        List<Integer> right = dfs(root.right, distance);
        for (int l : left) {
            for (int r : right) {

                if (l + r <= distance) {
                    count++;
                }
            }
        }
        for (int l : left) {
            if (l + 1 < distance) {
                result.add(l + 1);
            }
        }

        for (int r : right) {
            if (r + 1 < distance) {
                result.add(r + 1);
            }
        }

        return result;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna