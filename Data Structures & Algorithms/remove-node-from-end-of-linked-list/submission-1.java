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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        int size = 0;
        while(curr != null) {
            curr = curr.next;
            size++;
        }
        int target = size - n;
        if(target == 0) {
            head = head.next;
            return head;
        }
        curr = head;
        for(int i = 0; i < target - 1; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        
        return head;
    }
}
