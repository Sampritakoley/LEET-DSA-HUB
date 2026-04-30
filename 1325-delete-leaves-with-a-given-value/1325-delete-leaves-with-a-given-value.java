class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return RemoveNode(root,target);
    }public TreeNode RemoveNode(TreeNode root,int target){
        if(root==null){
            return null;
        }
        
        root.left=RemoveNode(root.left,target);
        root.right=RemoveNode(root.right,target);

        if(root.left==null && root.right==null && root.val==target){
            return null;
        }
        return root;
    }
}