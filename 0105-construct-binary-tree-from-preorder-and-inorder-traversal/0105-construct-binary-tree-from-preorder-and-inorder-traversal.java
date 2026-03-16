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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=preorder.length-1;
        TreeNode node=Constract(preorder,0,n,inorder,0,n);
        return node;
    }public TreeNode Constract(int[]preorder, int preSt, int preEd, int[] inorder, int inSt,int inEd){
        if(preSt>preEd || inSt>inEd){
            return null;
        }
        
        int rootVal=preorder[preSt];
        TreeNode root=new TreeNode(rootVal);
        int rootIndex=indexOf(inorder,rootVal);
        int noOfLeft=rootIndex-inSt;

        TreeNode leftSubtree=Constract(preorder,preSt+1,preSt+noOfLeft,inorder,inSt,rootIndex-1);
        TreeNode rightSubtree=Constract(preorder,preSt+noOfLeft+1,preEd,inorder,rootIndex+1,inEd);

        root.left=leftSubtree;
        root.right=rightSubtree;
        return root;
    }

     public static int indexOf(int[] arr, int target) {
        if (arr == null) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; 
            }
        }
        return -1; 
    }
}

