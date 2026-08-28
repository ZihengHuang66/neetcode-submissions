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
    public ListNode reverseList(ListNode head) {
        if(head != null) {
            ListNode curr = head.next;
            head.next = null;
            while(curr != null) {
                ListNode temp = curr.next;
                curr.next = head;
                head = curr;
                curr = temp;
            }
            return head;
        }
        return null;
    }
}
