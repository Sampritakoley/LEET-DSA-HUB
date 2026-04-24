
public class Codec {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helper(root, sb);
        return sb.toString();
    }

    private void helper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null,");
            return;
        }

        sb.append(node.val).append(",");
        helper(node.left, sb);
        helper(node.right, sb);
    }

    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        int[] index = new int[1]; // pointer
        return build(arr, index);
    }

    private TreeNode build(String[] arr, int[] index) {
        if (arr[index[0]].equals("null")) {
            index[0]++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(arr[index[0]++]));
        node.left = build(arr, index);
        node.right = build(arr, index);

        return node;
    }
}