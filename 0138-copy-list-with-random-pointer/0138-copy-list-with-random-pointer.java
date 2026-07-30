class Solution {
    public Node copyRandomList(Node head) {

        if (head == null)
            return null;


        HashMap<Node, Node> map = new HashMap<>();


        Node curr = head;

        while (curr != null) {

            map.put(curr, new Node(curr.val));

            curr = curr.next;
        }


        curr = head;

        while (curr != null) {

            Node copy = map.get(curr);

            copy.next = map.get(curr.next);

            copy.random = map.get(curr.random);

            curr = curr.next;
        }


        return map.get(head);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna