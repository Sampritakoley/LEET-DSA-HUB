class Solution {
    public class pair{
        int row;
        int col;
        TreeNode node;
        public pair(TreeNode node,int row,int col){
            this.row=row;
            this.col=col;
            this.node=node;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> mp = new TreeMap<>();
        
        Queue<pair> queue = new LinkedList<>();
        queue.offer(new pair(root, 0, 0)); 
        
        while (!queue.isEmpty()) {
            pair p = queue.poll();
            TreeNode node = p.node;
            int row = p.row;
            int col = p.col;
            
            mp.putIfAbsent(col, new TreeMap<>());
            mp.get(col).putIfAbsent(row, new PriorityQueue<>());
            mp.get(col).get(row).offer(node.val);
            
            if (node.left != null)
                queue.offer(new pair(node.left, row + 1, col - 1));
            
            if (node.right != null)
                queue.offer(new pair(node.right, row + 1, col + 1));
        }
        
        List<List<Integer>> result = new ArrayList<>();
        
        for (TreeMap<Integer, PriorityQueue<Integer>> rows : mp.values()) {
            List<Integer> columnList = new ArrayList<>();
            
            for (PriorityQueue<Integer> pq : rows.values()) {
                while (!pq.isEmpty()) {
                    columnList.add(pq.poll());
                }
            }
            
            result.add(columnList);
        }
        
        return result;
    
    }
}