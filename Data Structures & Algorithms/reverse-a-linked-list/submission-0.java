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
        ListNode prevHead =null;
        ListNode nextHead = null;
        while(head!=null){
            //1--2--3
            nextHead = head.next;
            head.next = prevHead;
            prevHead = head;
            head = nextHead;
        }
        return prevHead;     
    }
}
