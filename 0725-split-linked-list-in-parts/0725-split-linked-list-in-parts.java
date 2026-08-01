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
    public ListNode[] splitListToParts(ListNode head, int k) {

        int length = 0;
        ListNode curr = head;

        while (curr != null) {
            length++;
            curr = curr.next;
        }

        ListNode[] result = new ListNode[k];

        curr = head;

        int baseSize = length / k;
        int extra = length % k;

        for (int i = 0; i < k; i++) {

            int partSize = baseSize;

            if (extra > 0) {
                partSize++;
                extra--;
            }

            result[i] = curr;

            for (int j = 1; j < partSize; j++) {
                curr = curr.next;
            }

            if (curr != null) {
                ListNode nextPart = curr.next;
                curr.next = null;
                curr = nextPart;
            }
        }

        return result;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna