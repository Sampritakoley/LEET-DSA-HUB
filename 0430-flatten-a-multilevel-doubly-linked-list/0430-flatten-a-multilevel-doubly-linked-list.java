/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {

    public Node flatten(Node head) {

        if (head == null)
            return head;

        dfs(head);

        return head;
    }
    private Node dfs(Node node) {
        Node curr = node;
        Node last = null;
        while (curr != null) {
            Node next = curr.next;
            if (curr.child == null) {
                last = curr;
            } else {
                Node childHead = curr.child;
                Node childTail = dfs(childHead);
                curr.next = childHead;
                childHead.prev = curr;
                curr.child = null;
                if (next != null) {
                    childTail.next = next;
                    next.prev = childTail;
                }
                last = childTail;
            }
            curr = next;
        }
        return last;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna