/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
    if(head == null)return null;
    Node temp = head;
    //store node list values in array
    List<Integer>vals = new ArrayList<>();
    int index = 0;
    while(temp!=null){
        vals.add(temp.val);
        temp.val = index++;//replace the head values with their index
        temp = temp.next;
    }
    temp = head;
    //list to store the index to which the current node's random is pointing
    List<Integer>randomIndex = new ArrayList<>(); 
    while(temp!=null){
        if(temp.random==null)randomIndex.add(-1);
        else randomIndex.add(temp.random.val);
        temp = temp.next;
    }

    Node newHead = new Node(vals.get(0));
    Node ans = newHead;
    //stores the new nodes in a list
    List<Node>newNodes = new ArrayList<>();
    newNodes.add(newHead);
    //create the deepCopy
    Integer total = vals.size();
    for(int i=1;i<total;i++){
        newHead.next = new Node(vals.get(i));
        newHead = newHead.next;
        newNodes.add(newHead);
    }
    newHead = ans;
    //based on index of randoms, create the copy for random nodes
    for(int i=0;i<total;i++){
        if(randomIndex.get(i)==-1)newHead.random = null;
        else newHead.random = newNodes.get(randomIndex.get(i));
        newHead = newHead.next;
    }

    return ans;
    }
}
