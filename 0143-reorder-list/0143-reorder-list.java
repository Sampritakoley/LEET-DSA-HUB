class Solution {

    ListNode fleft;
    int size = 0;

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        fleft = head;
        foldHelper(head, 0);
    }

    private void foldHelper(ListNode right, int floor) {
        if (right == null) return;

        foldHelper(right.next, floor + 1);

        if (floor > size / 2) {
            ListNode temp = fleft.next;
            fleft.next = right;
            right.next = temp;
            fleft = temp;
        } 
        else if (floor == size / 2) {
            right.next = null;  
        }
    }
}
