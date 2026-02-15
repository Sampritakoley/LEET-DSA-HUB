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
        HashMap<Integer,Integer> map=new HashMap<>();
        mapInorderIndex(inorder,map);
        TreeNode root=ConstructTree(postorder,0,postorder.length-1,inorder,0,inorder.length-1,map);
        return root;
    }public void mapInorderIndex(int[] inorder,HashMap<Integer,Integer> map){
         int i=0;
         while(i<inorder.length){
            map.put(inorder[i],i);
            i++;
         }
    }public TreeNode ConstructTree(int[] postorder,int postSt,int postEd,int[] inorder,int inSt,int inEd,HashMap<Integer,Integer> map) {
        if(postSt>postEd || inSt>inEd){
            return null;
        }
         
        int rootVal = postorder[postEd];    
        int rootIndex = map.get(rootVal);
        TreeNode root=new TreeNode(rootVal);
        int noLeft=rootIndex-inSt;
        TreeNode leftNode=ConstructTree(postorder,postSt,postSt+noLeft-1,inorder,inSt,rootIndex-1,map);
        TreeNode rightNode=ConstructTree(postorder,postSt+noLeft,postEd-1,inorder,rootIndex+1,inEd,map);
        root.left=leftNode;
        root.right=rightNode;
        return root;
    }
}