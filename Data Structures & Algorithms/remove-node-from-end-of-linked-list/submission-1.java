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
        int count = 0;
        ListNode temp = head;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        temp = head;
        if(n==count)return head.next;
        int b4n = count-n-1;
        while(b4n>0){
            b4n--;
            temp = temp.next;
        }
        //temp has become the node just before deleted node;
        //if n==1, temp.next = null
        //temp.next = temp.next.next;
        if(n==1)temp.next = null;
        else temp.next = temp.next.next;
        return head;
    }
}
