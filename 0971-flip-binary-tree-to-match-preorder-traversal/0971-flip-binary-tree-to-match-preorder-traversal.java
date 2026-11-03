class Solution {

    List<Integer> result = new ArrayList<>();
    int index = 0;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {

        if (!dfs(root, voyage)) {
            return Arrays.asList(-1);
        }

        return result;
    }

    private boolean dfs(TreeNode root, int[] voyage) {

        if (root == null) {
            return true;
        }
        if (index >= voyage.length || root.val != voyage[index]) {
            return false;
        }

        index++;
        if (root.left != null &&
            index < voyage.length &&
            root.left.val != voyage[index]) {
            result.add(root.val);
            return dfs(root.right, voyage) &&
                   dfs(root.left, voyage);
        }
        return dfs(root.left, voyage) &&
               dfs(root.right, voyage);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna