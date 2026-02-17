class MyLinkedList {
    private class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }
    
    public int get(int index) {
        if (index < 0 || index >= size) {
        return -1;
        }

        Node temp=head;
        int i=0;
        while(i!=index){
            i++;
            temp=temp.next;
        }
        return temp.val;
    }
    
    public void addAtHead(int val) {
        Node first=new Node(val);
        first.next=head;
        head=first;
        size++;
    }
    
    public void addAtTail(int val) {
        Node last=new Node(val);
        if(head==null){
            head=last;
        }else{
            Node temp=head;
            while(temp.next!=null){
               temp=temp.next;
            }
            temp.next=last;
        }
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        
        if (index == 0) {
            addAtHead(val);
            return;
        }
        Node newNode=new Node(val);
        int i=0;
        Node temp=head;
        while(i<index-1){
            temp=temp.next;
            i++;
        }
        newNode.next=temp.next;
        temp.next=newNode;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        
        if (index == 0) {
            head = head.next;
        }else{
        int i=0;
        Node temp=head;
        while(i<index-1){
            temp=temp.next;
            i++;
        }
        temp.next=temp.next.next;
        
        }
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */