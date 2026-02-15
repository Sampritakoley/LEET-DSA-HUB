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
        HashMap<Integer,Integer> map=new HashMap<>();
        mapInorderIndex(inorder,map);
        TreeNode root=ConstructTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
        return root;
    }public void mapInorderIndex(int[] inorder,HashMap<Integer,Integer> map){
         int i=0;
         while(i<inorder.length){
            map.put(inorder[i],i);
            i++;
         }
    }public TreeNode ConstructTree(int[] preorder,int preSt,int preEd,int[] inorder,int inSt,int inEd,HashMap<Integer,Integer> map) {
        if(preSt>preEd || inSt>inEd){
            return null;
        }
         
        int rootVal = preorder[preSt];    
        int rootIndex = map.get(rootVal);
        TreeNode root=new TreeNode(rootVal);
        int noLeft=rootIndex-inSt;
        TreeNode leftNode=ConstructTree(preorder,preSt+1,preSt+noLeft,inorder,inSt,rootIndex-1,map);
        TreeNode rightNode=ConstructTree(preorder,preSt+noLeft+1,preEd,inorder,rootIndex+1,inEd,map);
        root.left=leftNode;
        root.right=rightNode;
        return root;
    }
}