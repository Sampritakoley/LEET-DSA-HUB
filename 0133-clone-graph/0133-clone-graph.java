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
         if (node == null) return null; 
        HashMap<Node,Node> map=new HashMap<>();
        return Dfs(node,map);
    }
    public Node Dfs(Node node,HashMap<Node,Node> map){
        if(map.containsKey(node)){
             return map.get(node);
        }

        Node cloned=new Node(node.val);
        map.put(node,cloned);

        for(Node neighbor:node.neighbors){
            Node clonedNeighbor=Dfs(neighbor,map);
            cloned.neighbors.add(clonedNeighbor);
        }
        return cloned;
    }
}