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
        ListNode temp = head;
        int count = 0;
        //count total nodes
        while(temp!=null){
            temp = temp.next;
            count++;
        }
        //find midpoint
        count/=2;
        count++;
        //System.out.println(count);
        temp = head;
        ListNode main = null;
        while(count!=0){
            main  = temp;
            temp = temp.next;
            count--;
        }
        main.next = null;
        //reverse the listnodes after midpoint
        ListNode secondHalf = temp;
        //System.out.println(temp.val);
        ListNode prev = null;
        while(temp!=null){
            temp = temp.next;
            secondHalf.next = prev;
            prev = secondHalf;
            secondHalf = temp;
        }
        secondHalf = prev;
        //join the two halves. 2nd half will always be less in length
        temp = head;
        ListNode current = head;
            //ct1--2--3  //sA--B--C;
        while(secondHalf!=null){
            //c1--t2--3 //sA-B-C
            temp = current.next;
            //c1-SA-B-C //t2-3
            current.next = secondHalf;
            //1-sa-b-c //ct2-3
            current = temp;
            //1-sa-tb-c //c2-3
            temp = secondHalf.next;
            //1-sa-c2-3 //tb-c
            secondHalf.next = current;
            //1-a-c2-3 //stb-c
            secondHalf = temp;
        }
    }
}
