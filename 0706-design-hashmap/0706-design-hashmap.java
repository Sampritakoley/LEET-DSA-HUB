class MyHashMap {

    class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node[] buckets;
    private int capacity = 1000;

    public MyHashMap() {
        buckets = new Node[capacity];
    }
    private int hash(int key) {
        return key % capacity;
    }

    public void put(int key, int value) {

        int index = hash(key);
        Node curr = buckets[index];

        while (curr != null) {

            if (curr.key == key) {
                curr.value = value;
                return;
            }

            curr = curr.next;
        }
        Node node = new Node(key, value);

        node.next = buckets[index];
        buckets[index] = node;
    }

    public int get(int key) {

        int index = hash(key);

        Node curr = buckets[index];

        while (curr != null) {

            if (curr.key == key) {
                return curr.value;
            }

            curr = curr.next;
        }

        return -1;
    }

    public void remove(int key) {

        int index = hash(key);

        Node curr = buckets[index];
        Node prev = null;

        while (curr != null) {

            if (curr.key == key) {

                if (prev == null) {
                    buckets[index] = curr.next;
                } else {
                    prev.next = curr.next;
                }

                return;
            }

            prev = curr;
            curr = curr.next;
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna