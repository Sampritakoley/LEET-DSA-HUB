class Solution {

    public int findTheWinner(int n, int k) {

        Node head = new Node(1);
        Node tail = head;

        for (int i = 2; i <= n; i++) {
            tail.next = new Node(i);
            tail = tail.next;
        }

        tail.next = head;

        Node curr = head;
        Node prev = tail;
        while (curr.next != curr) {
            for (int i = 1; i < k; i++) {
                prev = curr;
                curr = curr.next;
            }
            prev.next = curr.next;
            curr = curr.next;
        }

        return curr.val;
    }

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna