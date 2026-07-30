public class Solution {
    public boolean hasCycle(ListNode head) {

        ListNode f = head; 
        ListNode s = head; 

        while (f != null && f.next != null) {

            f = f.next.next; 
            s = s.next;     

            if (f == s) {
                return true;
            }
        }

        return false;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna