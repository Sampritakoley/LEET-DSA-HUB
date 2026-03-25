class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
          HashMap<TreeNode,Integer> parent=new HashMap<>();
          parent.put(root,-1);
          buildParent(parent,root);
          Queue<TreeNode> q=new LinkedList<>();
          q.add(root);
          while(q.size()>0){
            int levelsize=q.size(); int parentx=-1; int parenty=-1;
            for(int i=0;i<levelsize;i++){
                TreeNode c=q.poll();
                if(c.val==x){
                    parentx=parent.get(c);
                }
                if(c.val==y){
                    parenty=parent.get(c);
                }

                if(c.left!=null){
                    q.offer(c.left);
                }

                if(c.right!=null){
                    q.offer(c.right);
                }
            }
            if(parentx!=-1 && parenty!=-1 && parentx!=parenty){
                return true;
            }
            if (parentx != -1 || parentx != -1) {
                return false;
            }
          }
          return false;
    }public void buildParent(HashMap<TreeNode,Integer> parent, TreeNode root){
        if(root==null){
            return;
        }
        if(root.left!=null){
            parent.put(root.left,root.val);
            buildParent(parent,root.left);
        }
        if(root.right!=null){
            parent.put(root.right,root.val);
            buildParent(parent,root.right);
        }
    }
}