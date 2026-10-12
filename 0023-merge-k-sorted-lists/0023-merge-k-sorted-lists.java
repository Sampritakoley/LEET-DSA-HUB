
import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.val, b.val)
        );
        
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (!minHeap.isEmpty()) {
            ListNode smallest = minHeap.poll();

            current.next = smallest;
            current = current.next;
            if (smallest.next != null) {
                minHeap.offer(smallest.next);
            }
        }

        return dummy.next;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna