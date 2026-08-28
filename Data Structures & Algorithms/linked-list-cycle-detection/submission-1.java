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
    public boolean hasCycle(ListNode head) {
        if(head == null)  {
            return false;
        } else {
            ListNode fast = head;
            ListNode slow = head;
            if(fast.next == null) {
                return false;
            } else {
                fast = fast.next;
            }
            while(!fast.equals(slow)) {
                fast = fast.next;
                if(fast == null || fast.next == null) {
                    return false;
                }
                fast = fast.next;
                slow = slow.next;
            }
            return true;
        }
    }
}
