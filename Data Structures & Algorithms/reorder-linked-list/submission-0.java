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
    public void reorderList(ListNode head) {
        ListNode curr = head;
        int size = 0;
        while(curr != null) {
            curr = curr.next;
            size++;
        }
        curr = head;
        int mid = 0;
        if(size % 2 == 0) {
            mid = size / 2;
        } else {
            mid = size / 2 + 1;
        }

        curr = head;
        for(int i = 0; i < mid - 1; i++) {
            curr = curr.next;
        }
        ListNode temp = curr.next;
        curr.next = null;
        temp = reverseList(temp);

        ListNode node1 = head;
        while(node1 != null && temp != null) {
            ListNode node2 = node1.next;
            node1.next = temp;
            temp = temp.next;
            node1.next.next = node2;
            node1 = node1.next.next;     
        }
    }
/*
node1(head): 0 1 2 3
(temp): 6 5 4
*/
    private static ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }
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
    // 6 8
}
