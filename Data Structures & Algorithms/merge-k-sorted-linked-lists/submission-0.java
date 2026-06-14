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
    public ListNode mergeKLists(ListNode[] lists) {
        int end = 0;
        ListNode ans  = new ListNode();
        ListNode res = ans;
        int minVal = 1001;
        int minIndex = 0;
        while(end!=lists.length){
            minVal = 1001;
            for(int i=0;i<lists.length;i++){
                if(lists[i]!=null && lists[i].val<=minVal){
                    minVal = lists[i].val;
                    minIndex = i;
                }
            }
            ans.next = lists[minIndex];
            ans = lists[minIndex];
            lists[minIndex] = lists[minIndex].next;
            if(lists[minIndex]==null)end++;
        }
        return res.next;
    }
}
