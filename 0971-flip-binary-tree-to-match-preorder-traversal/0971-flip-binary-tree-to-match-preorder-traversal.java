class Solution {

    int index = 0;
    List<Integer> flips = new ArrayList<>();

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {

        if (!dfs(root, voyage)) {
            return Arrays.asList(-1);
        }

        return flips;
    }

    private boolean dfs(TreeNode node, int[] voyage) {

        if (node == null) {
            return true;
        }
        if (index >= voyage.length || node.val != voyage[index]) {
            return false;
        }
        index++;
        if (node.left != null &&
            index < voyage.length &&
            node.left.val != voyage[index]) {
            if (node.right == null ||
                node.right.val != voyage[index]) {
                return false;
            }
            flips.add(node.val);
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        return dfs(node.left, voyage) &&
               dfs(node.right, voyage);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna