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

    ListNode th = null;
    ListNode tt = null;

    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || k == 1)
            return head;

        int len = length(head);

        ListNode curr = head;

        ListNode oh = null;  
        ListNode ot = null; 

        while (len >= k) {

            th = null;
            tt = null;

            for (int i = 0; i < k; i++) {

                ListNode next = curr.next;

                curr.next = null;

                addFirst(curr);

                curr = next;
            }

            if (oh == null) {
                oh = th;
                ot = tt;
            }
            else {
                ot.next = th;
                ot = tt;
            }

            len -= k;
        }
        ot.next = curr;

        return oh;
    }

    private void addFirst(ListNode node) {

        if (th == null) {
            th = node;
            tt = node;
        } else {
            node.next = th;
            th = node;
        }
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