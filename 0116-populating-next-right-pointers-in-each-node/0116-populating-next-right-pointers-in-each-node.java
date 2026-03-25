/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> q=new LinkedList<>();
        if(root==null){
            return root;
        }
        q.offer(root);
        while(q.size()>0){
            int levelsize=q.size();
            Node prev=null;
            for(int i=0;i<levelsize;i++){
                Node current=q.poll();
                if(current.left!=null){
                    q.offer(current.left);
                }
                if(current.right!=null){
                    q.offer(current.right);
                }

                if(prev!=null){
                    prev.next=current;
                }
                prev=current;
            }
            prev.next=null;
        }
        return root;
    }
}