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

    ListNode left;

    public boolean isPalindrome(ListNode head) {

        left = head;

        return check(head);
    }


    private boolean check(ListNode right) {

        if (right == null) {
            return true;
        }


        boolean result = check(right.next);


        if (!result) {
            return false;
        }


        if (left.val != right.val) {
            return false;
        }


        left = left.next;


        return true;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna