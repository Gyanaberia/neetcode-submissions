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
        if(list1 == null)return list2;
        if(list2 == null)return list1;
        ListNode currentHead ;
        if(list1.val<=list2.val){
            currentHead = list1;
            list1 = list1.next;
        }else{
            currentHead = list2;
            list2 = list2.next;
        }
        ListNode tempHead = currentHead;
        System.out.println(tempHead.val);
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                tempHead.next = list1;
                tempHead = list1;
                list1 = list1.next;    
            }else{
                tempHead.next = list2;
                tempHead = list2;
                list2 = list2.next;                  
            }
        }
        if(list1!=null){
            tempHead.next = list1;
        }else if(list2!=null){
            tempHead.next = list2;
        }
        return currentHead; 
        

    }
}