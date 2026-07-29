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
    int size=1;
    public ListNode reverseList(ListNode head) {
        int left=0;
        int right=getsize(head)-1;
        while(left<right){
            ListNode leftNode=getatIndex(head,left);
            ListNode rightNode=getatIndex(head,right);
            int tempval=leftNode.val;
            leftNode.val=rightNode.val;
            rightNode.val=tempval;
            left++;
            right--;
        }
        return head;
    }public static ListNode getatIndex(ListNode head,int ind){
        ListNode temp=head; int i=0;
        while(i<ind){
            temp=temp.next;
            i++;
        }
        return temp;
    }public static int getsize(ListNode head){
        ListNode temp=head; int size=0;
        while(temp!=null){
            temp=temp.next;
            size++;
        }
        return size;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna