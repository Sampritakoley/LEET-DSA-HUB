/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       int lenA = getLength(headA);
    int lenB = getLength(headB);

    ListNode a = headA;
    ListNode b = headB;

    if (lenA > lenB) {
        for (int i = 0; i < lenA - lenB; i++)
            a = a.next;
    } else {
        for (int i = 0; i < lenB - lenA; i++)
            b = b.next;
    }

    while (a != b) {
        a = a.next;
        b = b.next;
    }

    return a;
}

private int getLength(ListNode node) {
    int count = 0;
    while (node != null) {
        count++;
        node = node.next;
    }
    return count;
    }
}