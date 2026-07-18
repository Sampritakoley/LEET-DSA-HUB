class LRUCache {
    public static class Node{
        int key;
        int val;
        Node prev;
        Node next;
        public Node(int key, int val){
            this.key=key;
            this.val=val;
        }
    }
    private int capacity;
    private Node head;
    private Node tail;
    private Map<Integer,Node> map;

    public LRUCache(int capacity) {
       this.capacity=capacity;
       map=new HashMap<>();
       head=new Node(0,0);
       tail=new Node(0,0);

       head.next=tail;
       tail.prev=head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        Node currentNode=map.get(key);
        removeNode(currentNode);
        addAtFirst(currentNode);
        return currentNode.val;
    }
    
    public void put(int key, int value) {
        if(capacity==0){
            return;
        }
        if(map.containsKey(key)){
            Node node=map.get(key);
            node.val=value;
            removeNode(node);
            addAtFirst(node);
            return;
        }

        Node newNode=new Node(key,value);
        map.put(key,newNode);
        addAtFirst(newNode);

        if(capacity<map.size()){
            Node lru=tail.prev;
            removeNode(lru);
            map.remove(lru.key);
        }
    }
    private void addAtFirst(Node node) {

        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna