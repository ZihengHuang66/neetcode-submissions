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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr = l1;
        ListNode temp = l2;
        int carry = (curr.val + temp.val) / 10;
        ListNode result = null;
        if(carry != 0) {
            result = new ListNode(curr.val + temp.val - 10);
        } else {
            result = new ListNode(curr.val + temp.val);
        }
        curr = curr.next;
        temp = temp.next;
        ListNode add = result;

        while(curr != null || temp != null) {
            if(curr == null) {
                int prevCarry = carry;
                carry = (temp.val + prevCarry) / 10;
                if(carry != 0) {
                    add.next = new ListNode(temp.val - 10 + prevCarry);
                } else {
                    add.next = new ListNode(temp.val + prevCarry);
                }
                temp = temp.next;
                add = add.next;
            } else if(temp == null) {
                int prevCarry = carry;
                carry = (curr.val + prevCarry) / 10;
                if(carry != 0) {
                    add.next = new ListNode(curr.val - 10 + prevCarry);
                } else {
                    add.next = new ListNode(curr.val + prevCarry);
                }
                curr = curr.next;
                add = add.next;
            } else {
                int prevCarry = carry;
                carry = (curr.val + temp.val + prevCarry) / 10;
                if(carry != 0) {
                    add.next = new ListNode(curr.val + temp.val - 10 + prevCarry);
                } else {
                    add.next = new ListNode(curr.val + temp.val + prevCarry);
                }
                curr = curr.next;
                temp = temp.next;
                add = add.next;
            }
        }
        if(carry != 0) {
            add.next = new ListNode(carry);
        }
        return result;
    }
}
