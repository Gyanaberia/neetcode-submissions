class LRUCache {
    private int cap;
    //key-value
    //key-index
    //index array also stores next index;
    //new element n1 to full element replaces the dropping element.prev = prev's next;
    //new element n2. n1's next is n2;
    //if value replaces
    //n1->r, and r's prev->next = r's next;
    //key, {value, prev key,next key}
    HashMap<Integer,int[]>lru;
    int head = -1,tail = -1;
    public LRUCache(int capacity) {
        this.cap = capacity;
        this.lru = new HashMap<>();
    }
    
    public int get(int key) {
        if(lru.containsKey(key)){
            this.updateOrder(key);
            if(lru.containsKey(tail)){
            lru.get(tail)[2] = key;//old's tail next is key
            }
            int[] arr = lru.get(key);
            arr[1] = tail;
            arr[2] = -1;
            tail = key;            
            return arr[0];
            }
        return -1;        
    }
    
    public void put(int key, int value) {
        if(lru.size()==0){
            head = key;
        }else if(lru.containsKey(key)){
            this.updateOrder(key);
        }else if (lru.size()==cap){
            System.out.println(key+ " " +head);
            //Remove head
            int temp = head;
            int[] arr = lru.get(head);
            //if next element exists
            if(arr[2]!=-1){
                head = arr[2];

            }
            System.out.println("after update " +head);
            lru.remove(temp);
        }
        //attach tail
        if(lru.containsKey(tail)){
            lru.get(tail)[2] = key;//old's tail next is key
        }
        lru.put(key,new int[]{value,tail,-1});
        tail = key;
    }

    private void updateOrder(int key){
        int[] arr = lru.get(key);
        //if key is head and its next node exist, update the head
        if(key==head && arr[2]!=-1){
            head = arr[2];
        }
        //connect the prev and next nodes
        else if(key!=head && arr[2]!=-1){
            lru.get(arr[1])[2] = arr[2];
            lru.get(arr[2])[1] = arr[1];
        }
        //if its already the last element
        else if(key==tail){
            tail = arr[1];//this value is later used to update the array
        }        
    }
}
