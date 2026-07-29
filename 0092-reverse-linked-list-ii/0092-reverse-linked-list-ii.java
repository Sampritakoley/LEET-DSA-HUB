/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy=new ListNode(0);
        if (head == null || left == right)
            return head;
        dummy.next=head;int i=1; ListNode prev=dummy;
        while(i<left){
           i++;
           prev=prev.next;
        }
        ListNode previous=null;
        ListNode current=prev.next;
        for (int j = 0; j < right - left + 1; j++) {
            ListNode store=current.next;
            current.next=previous;
            previous=current;
            current=store;
        }
        ListNode leftNode = prev.next;
        leftNode.next = current;
        prev.next = previous;
        return dummy.next;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna