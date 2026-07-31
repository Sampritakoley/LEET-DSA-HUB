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

    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || k == 1)
            return head;

        int len = length(head);

        ListNode curr = head;

        ListNode overallHead = null;
        ListNode overallTail = null;

        while (len >= k) {

            ListNode th = null; 
            ListNode tt = null; 

            for (int i = 0; i < k; i++) {

                ListNode next = curr.next;
                curr.next = null;

                if (th == null) {
                    th = curr;
                    tt = curr;
                } else {
                    curr.next = th;
                    th = curr;
                }

                curr = next;
            }

            if (overallHead == null) {
                overallHead = th;
                overallTail = tt;
            } else {
                overallTail.next = th;
                overallTail = tt;
            }

            len -= k;
        }

        overallTail.next = curr;

        return overallHead;
    }

    private int length(ListNode head) {

        int len = 0;

        while (head != null) {
            len++;
            head = head.next;
        }

        return len;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna