class LFUCache {

    public static class Node{
        int key;
        int val;
        int freq;
        Node prev;
        Node next;

        public Node(int key,int val){
            this.key=key;
            this.val=val;
            this.freq=1;
        }
    }

    public class DLinkedList{
        Node head;
        Node tail;
        int size;
        public DLinkedList(){
            this.size=0;
            head=new Node(0,0);
            tail=new Node(0,0);

            head.next=tail;
            tail.prev=head;
        }

        void addFirst(Node node) {

            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;

            size++;
        }


        void remove(Node node) {

            node.prev.next = node.next;
            node.next.prev = node.prev;

            size--;
        }


        Node removeLast() {

            if (size == 0) {
                return null;
            }

            Node node = tail.prev;

            remove(node);

            return node;
        }
    }
    
    private int cap;
    private Map<Integer,Node> nodeMap;
    private Map<Integer,DLinkedList> freqMap;
    private int minFreq;
    public LFUCache(int capacity) {
        this.cap=capacity;
        this.nodeMap=new HashMap<>();
        this.freqMap=new HashMap<>();
        minFreq=0;
    }
    public void updateFrequnecy(Node node){
        int freq=node.freq;
        DLinkedList dl=freqMap.get(freq);
        if(freq==minFreq && dl.size==1){
           minFreq++;
        }
        dl.remove(node);
        node.freq++;
        freqMap.computeIfAbsent(node.freq,k->new DLinkedList()).addFirst(node);
    }
    public int get(int key) {
        if(!nodeMap.containsKey(key)){
            return -1;
        }

        Node current=nodeMap.get(key);
        updateFrequnecy(current);
        return current.val;
    }

    
    
    public void put(int key, int value) {
         
         if(cap==0){
            return;
         }

         if(nodeMap.containsKey(key)){
             Node node=nodeMap.get(key);
             node.val=value;

             updateFrequnecy(node);
             return;
         }
          
         if(cap==nodeMap.size()){
            DLinkedList dll=freqMap.get(minFreq);
            Node popedNode=dll.removeLast();
            nodeMap.remove(popedNode.key);
         }

         Node newNode=new Node(key,value);
         nodeMap.put(key,newNode);
         minFreq=1;
         freqMap.computeIfAbsent(1,k->new DLinkedList()).addFirst(newNode);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna