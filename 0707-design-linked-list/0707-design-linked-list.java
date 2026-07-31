class MyLinkedList {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    private ListNode head;
    private ListNode tail;
    private int size;

    public MyLinkedList() {}

    public int get(int index) {
        if (index < 0 || index >= size) return -1;

        ListNode curr = head;
        while (index-- > 0)
            curr = curr.next;

        return curr.val;
    }

    public void addAtHead(int val) {

        ListNode node = new ListNode(val);

        node.next = head;
        head = node;

        if (size == 0)
            tail = node;

        size++;
    }

    public void addAtTail(int val) {

        if (size == 0) {
            addAtHead(val);
            return;
        }

        ListNode node = new ListNode(val);

        tail.next = node;
        tail = node;

        size++;
    }

    public void addAtIndex(int index, int val) {

        if (index < 0 || index > size)
            return;

        if (index == 0) {
            addAtHead(val);
            return;
        }

        if (index == size) {
            addAtTail(val);
            return;
        }

        ListNode prev = head;

        for (int i = 0; i < index - 1; i++)
            prev = prev.next;

        ListNode node = new ListNode(val);

        node.next = prev.next;
        prev.next = node;

        size++;
    }

    public void deleteAtIndex(int index) {

        if (index < 0 || index >= size)
            return;

        if (index == 0) {

            head = head.next;
            size--;

            if (size == 0)
                tail = null;

            return;
        }

        ListNode prev = head;

        for (int i = 0; i < index - 1; i++)
            prev = prev.next;

        if (prev.next == tail)
            tail = prev;

        prev.next = prev.next.next;

        size--;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna