class Solution {

    public String getDirections(
            TreeNode root,
            int startValue,
            int destValue) {

        StringBuilder startPath = new StringBuilder();
        StringBuilder destPath = new StringBuilder();
        findPath(root, startValue, startPath);
        findPath(root, destValue, destPath);
        int i = 0;

        while (i < startPath.length()
                && i < destPath.length()
                && startPath.charAt(i) == destPath.charAt(i)) {

            i++;
        }
        StringBuilder answer = new StringBuilder();

        for (int j = i; j < startPath.length(); j++) {
            answer.append('U');
        }
        answer.append(destPath.substring(i));

        return answer.toString();
    }

    private boolean findPath(
            TreeNode node,
            int target,
            StringBuilder path) {

        if (node == null) {
            return false;
        }

        if (node.val == target) {
            return true;
        }

        path.append('L');

        if (findPath(node.left, target, path)) {
            return true;
        }

        path.deleteCharAt(path.length() - 1);

        path.append('R');

        if (findPath(node.right, target, path)) {
            return true;
        }

        path.deleteCharAt(path.length() - 1);

        return false;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna