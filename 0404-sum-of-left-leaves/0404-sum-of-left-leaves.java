class Solution {
    public int sumOfLeftLeaves(TreeNode root) {

        if(root==null){
            return 0;
        }
        return findSum(root);
    }public int findSum(TreeNode root){
        int sum=0;

        if(root.left==null){
            sum=sum+0;
        }else{
            if(root.left.left==null && root.left.right==null){
                sum+=root.left.val;
            }else{
                sum+=findSum(root.left);
            }
        }

        if(root.right!=null){
            sum+=findSum(root.right);
        }

        return sum;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna