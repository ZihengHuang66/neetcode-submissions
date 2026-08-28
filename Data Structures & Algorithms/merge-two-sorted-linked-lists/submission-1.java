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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) {
            return list2;
        } else if(list2 == null) {
            return list1;
        } else {
            ListNode curr = list1;
            ListNode temp = list2;
            ListNode result = null;
            if(list1.val <= list2.val) {
                result = new ListNode(list1.val);
            } else {
                result = new ListNode(list2.val);
            }
            ListNode dummy = result;
            while(curr != null && temp != null) {
                if(curr.val <= temp.val) {
                    dummy.next = new ListNode(curr.val);
                    dummy = dummy.next;
                    curr = curr.next;
                } else {
                    dummy.next = new ListNode(temp.val);
                    dummy = dummy.next;
                    temp = temp.next;
                }
            }
            if(curr != null) {
                dummy.next = curr;
            } else if(temp != null) {
                dummy.next = temp;
            }
            result = result.next;
            return result;
        }
    }
}