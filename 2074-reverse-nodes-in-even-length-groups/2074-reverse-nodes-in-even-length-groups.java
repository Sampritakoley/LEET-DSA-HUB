class Solution {
    public ListNode reverseEvenLengthGroups(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode prevGroupTail = null;
        ListNode curr = head;

        int groupSize = 1;

        while (curr != null) {
            int count = 0;
            ListNode temp = curr;

            while (temp != null && count < groupSize) {
                temp = temp.next;
                count++;
            }
            if (count % 2 == 0) {

                ListNode prev = temp;
                ListNode groupTail = curr;

                for (int i = 0; i < count; i++) {

                    ListNode next = curr.next;

                    curr.next = prev;
                    prev = curr;
                    curr = next;
                }
                if (prevGroupTail != null) {
                    prevGroupTail.next = prev;
                } else {
                    head = prev;
                }

                prevGroupTail = groupTail;

            } else {
                prevGroupTail = curr;

                for (int i = 0; i < count; i++) {
                    prevGroupTail = curr;
                    curr = curr.next;
                }
            }

            groupSize++;
        }

        return head;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna