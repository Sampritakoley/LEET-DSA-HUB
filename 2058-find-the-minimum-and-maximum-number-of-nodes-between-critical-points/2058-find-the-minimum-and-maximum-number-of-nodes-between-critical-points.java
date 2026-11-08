class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int first = -1;
        int prev = -1;
        int minDist = Integer.MAX_VALUE;
        int position = 1;
        ListNode prevNode = head;
        ListNode curr = head.next;
        while (curr != null && curr.next != null) {
            ListNode next = curr.next;
            boolean isMax = curr.val > prevNode.val &&curr.val > next.val;
            boolean isMin = curr.val < prevNode.val &&curr.val < next.val;
            if (isMax || isMin) {
                if (first == -1) {
                    first = position;
                } 
                else {
                    minDist = Math.min(minDist, position - prev);
                }
                prev = position;
            }
            prevNode = curr;
            curr = curr.next;
            position++;
        }
        if (first == -1 || first == prev) {
            return new int[]{-1, -1};
        }
        int maxDist = prev - first;
        return new int[]{minDist, maxDist};
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna