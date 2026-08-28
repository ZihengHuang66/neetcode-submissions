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
    // Return early if the list is empty or has only one element
    if (head == null || head.next == null) {
        return false;
    }
    
    ListNode slow = head;
    ListNode fast = head;
    
    // Move pointers until the fast pointer reaches the end of the list
    while (fast != null && fast.next != null) {
        slow = slow.next;         // Moves 1 step
        fast = fast.next.next;    // Moves 2 steps
        
        // If they meet, there is a cycle
        if (slow == fast) {
            return true;
        }
    }
    
    // Fast pointer reached the end, so no cycle exists
    return false;
}
}
