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
    int s = 0,c = 0;
    ListNode temp1 = l1;
    ListNode temp2 = l2;
    while(l1.next!=null && l2.next!=null){
        s = l1.val+l2.val+c;
        c = s/10;
        l1.val = s%10;
        l2.val = s%10;
        l1 = l1.next;
        l2 = l2.next;
    }
        s = l1.val+l2.val+c;
        c = s/10;
        l1.val = s%10;
        l2.val = s%10;
    if(l1.next==null){
        if(l2.next == null && c!=0){
            l2.next = new ListNode(c);
            return temp2;
        }
        l2 = l2.next;
        while(c!=0){
                s = l2.val+c;
                l2.val = s%10;
                c = s/10;
                if(l2.next == null && c!=0) {    
                    l2.next = new ListNode(c);break;}
                l2 = l2.next;
            }
        return temp2;
    }else{
        l1 = l1.next;
        while(c!=0){
                s = l1.val+c;
                l1.val = s%10;
                c = s/10;
                if(l1.next == null && c!=0) {l1.next = new ListNode(c);break;}

                l1 = l1.next;
            }
        return temp1;
    }
    }
}
