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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n=inorder.length-1;
        TreeNode node=Constract(postorder,0,n,inorder,0,n);
        return node;
    }public TreeNode Constract(int[] postOrder,int postSt,int postEd, int[] inorder, int inSt,int inEd){
        if((postSt>postEd) || (inSt> inEd)){
            return null;
        }

        int rootVal=postOrder[postEd];
        TreeNode root=new TreeNode(rootVal);
        int rootInd=indexOf(inorder,rootVal);
        int noOfLeft=rootInd-inSt;

        TreeNode leftSubtree=Constract(postOrder,postSt,postSt+noOfLeft-1,inorder,inSt,rootInd-1);
        TreeNode rightSubtree=Constract(postOrder,postSt+noOfLeft,postEd-1,inorder,rootInd+1,inEd);
        
        root.left=leftSubtree;
        root.right=rightSubtree;
        return root;
    }
    public static int indexOf(int[] arr,int n){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==n){
                return i;
            }
        }
        return -1;
    }
}