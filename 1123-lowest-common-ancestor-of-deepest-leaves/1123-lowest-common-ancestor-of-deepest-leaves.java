/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public static class Pair{
        TreeNode node;
        int depth;
        public Pair(TreeNode node, int depth){
            this.node=node;
            this.depth=depth;
        }
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Pair p=lca(root);
        return p.node;
    }public Pair lca(TreeNode node){
        if(node==null){
            return new Pair(null,0);
        }

        Pair left=lca(node.left);
        Pair right=lca(node.right);

        if(left.depth==right.depth){
            return new Pair(node,left.depth+1);
        }

        if(left.depth>right.depth){
            return new Pair(left.node,left.depth+1);
        }else{
            return new Pair(right.node,right.depth+1);
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna