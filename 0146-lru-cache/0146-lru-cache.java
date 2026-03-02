class LRUCache {

     class Node {
        int key, value;
        Node prev, next;

        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private int capacity;
    private Map<Integer, Node> cache;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();

        // Dummy nodes to avoid edge cases
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        Node node = cache.get(key);
        moveToFront(node);
        return node.value;
    }

    public void put(int key, int value) {

        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            moveToFront(node);
        } else {

            if (cache.size() == capacity) {
                Node lru = removeTail();
                cache.remove(lru.key);
            }

            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addToFront(newNode);
        }
    }

    // ---------- Helper Methods ----------

    private void addToFront(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToFront(Node node) {
        removeNode(node);
        addToFront(node);
    }

    private Node removeTail() {
        Node lru = tail.prev;
        removeNode(lru);
        return lru;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */