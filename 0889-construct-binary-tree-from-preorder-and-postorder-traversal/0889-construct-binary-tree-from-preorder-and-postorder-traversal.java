class Solution {

    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {

        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }

        return build(
                preorder, 0, preorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd,
                           int[] postorder, int postStart, int postEnd) {

        if (preStart > preEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        if (preStart == preEnd) {
            return root;
        }

        int leftRoot = preorder[preStart + 1];

        int index = map.get(leftRoot);

        int leftSize = index - postStart + 1;

        root.left = build(
                preorder,
                preStart + 1,
                preStart + leftSize,
                postorder,
                postStart,
                index);

        root.right = build(
                preorder,
                preStart + leftSize + 1,
                preEnd,
                postorder,
                index + 1,
                postEnd - 1);

        return root;
    }
}