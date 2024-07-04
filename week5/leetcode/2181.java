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
    public ListNode mergeNodes(ListNode head) {
        head = head.next;

        ListNode newHead = new ListNode(0); 
        ListNode current = newHead;

        while (head != null) {
            int sum = 0;
            
            while (head != null && head.val != 0) {
                sum += head.val;
                head = head.next;
            }
            
            head = head != null ? head.next : null;
            
            current.next = new ListNode(sum);
            current = current.next;
        }
        
        return newHead.next;
    }
}