class Solution {

    class Tuple {
        TreeNode node;
        int row;
        int col;

        Tuple(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map =
                new TreeMap<>();

        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0, 0));

        while (!q.isEmpty()) {

            Tuple t = q.poll();

            map.putIfAbsent(t.col, new TreeMap<>());
            map.get(t.col).putIfAbsent(t.row, new PriorityQueue<>());

            map.get(t.col).get(t.row).offer(t.node.val);

            if (t.node.left != null) {
                q.offer(new Tuple(t.node.left, t.row + 1, t.col - 1));
            }

            if (t.node.right != null) {
                q.offer(new Tuple(t.node.right, t.row + 1, t.col + 1));
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {

            List<Integer> column = new ArrayList<>();

            for (PriorityQueue<Integer> pq : rows.values()) {

                while (!pq.isEmpty()) {
                    column.add(pq.poll());
                }
            }

            result.add(column);
        }

        return result;
    }
}