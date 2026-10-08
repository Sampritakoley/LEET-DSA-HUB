/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Node,Node> map=new HashMap<>();
        if(node==null){
            return null;
        }
        Node clone=new Node(node.val);
        Queue<Node> queue=new LinkedList<>();
        queue.offer(node);
        map.put(node,clone);
        while(!queue.isEmpty()){
            Node current=queue.poll();
            Node clonedNode=map.get(current);
            if(current.neighbors.size()==0){
                continue;
            }
            for(Node neighbor: current.neighbors){
                if(map.containsKey(neighbor)){
                    Node cloned_neigh=map.get(neighbor);
                    clonedNode.neighbors.add(cloned_neigh);
                }else{
                    Node cloned_neighbor=new Node(neighbor.val);
                    map.put(neighbor,cloned_neighbor);
                    queue.offer(neighbor);
                    clonedNode.neighbors.add(cloned_neighbor);
                }
                
            }
        }
        return clone;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna