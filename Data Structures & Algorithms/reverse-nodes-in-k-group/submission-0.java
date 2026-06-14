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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1)return head;
        ListNode start = new ListNode();
        ListNode nextStart = start;
        int count = k;
        ListNode cur = head;
        ListNode temp;
        ListNode ans = start;
        while(cur!=null){
            temp = cur.next;
            if(count!=k){
                cur.next = start.next;
                start.next = cur;
                //start->...->cur.next
                //start->cur.next->cur;
                count++;    
            }else{
                //change next start
                start = nextStart;
                nextStart = cur;
                start.next = cur;
                count = 1 ;
                cur.next = null;
                //System.out.println(head.val+" "+ start.val+" "+nextStart.val);
            }
            cur = temp;
        }
        //System.out.println(count);
        if(count!=k && count!=1){
            nextStart.next = null;//the last nextStart has a loop
            //unreverse the residual nodes
            while(start.next!=nextStart){
                cur = start.next;
                start.next = cur.next;
                cur.next = nextStart.next;
                nextStart.next = cur;
            }
        }
        return ans.next;

    }
}
