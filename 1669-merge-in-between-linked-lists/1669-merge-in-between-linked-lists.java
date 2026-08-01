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
    public ListNode mergeInBetween(
        ListNode list1,
        int a,
        int b,
        ListNode list2
    ) {

ListNode beforeA = list1;

        for (int i = 0; i < a - 1; i++) {
            beforeA = beforeA.next;
        }

        ListNode afterB = beforeA;

        for (int i = 0; i <b-a+2; i++) {
            afterB = afterB.next;
        }

        beforeA.next = list2;

        ListNode tail = list2;

        while (tail.next != null) {
            tail = tail.next;
        }

        tail.next = afterB;

        return list1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna