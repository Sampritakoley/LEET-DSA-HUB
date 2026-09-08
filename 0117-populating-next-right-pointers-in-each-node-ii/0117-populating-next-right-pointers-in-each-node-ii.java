class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Node current = root;

        while (current != null) {

            Node dummy = new Node(0);
            Node tail = dummy;

            while (current != null) {

                if (current.left != null) {
                    tail.next = current.left;
                    tail = tail.next;
                }

                if (current.right != null) {
                    tail.next = current.right;
                    tail = tail.next;
                }

                current = current.next;
            }

            current = dummy.next;
        }

        return root;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna