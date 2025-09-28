class ListNode{
    int key;
    int val;
    ListNode next;
    ListNode prev;
    ListNode(int key, int val, ListNode next, ListNode prev){
        this.key = key;
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}

class LRUCache {
    
    int size;
    Map<Integer,ListNode> map;
    int curr;
    ListNode mostUsed, leastUsed;

    public LRUCache(int capacity) {
        size = capacity;
        curr = 0;
        map = new HashMap<>();
        mostUsed = new ListNode(0,0,null,null);
        leastUsed = new ListNode(0,0,mostUsed,null);
        mostUsed.prev = leastUsed;
    }
    
    public int get(int key) {

        if(map.containsKey(key)){
            ListNode node = map.get(key);

            if(mostUsed.prev == node) return node.val;

            //move towards most Recently Used
            moveKeyToMostUsed(node);

            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {


        if(map.containsKey(key)){
            ListNode node = map.get(key);
            node.val = value;
            moveKeyToMostUsed(node);
        }

        else{
                if(curr==size){
                ListNode del = leastUsed.next;
                leastUsed.next = del.next;
                del.next.prev = leastUsed;
                del.next = null;
                del.prev = null;

                map.remove(del.key);
                curr--;
            }
            ListNode newNode = new ListNode(key,value,null,null);
            ListNode left = mostUsed.prev;
            mostUsed.prev = newNode;
            newNode.prev = left;
            left.next = newNode;
            newNode.next = mostUsed;
            curr++;
            map.put(key, newNode);
        }
    }

    void moveKeyToMostUsed(ListNode node){
        node.next.prev = node.prev;
            node.prev.next = node.next;

            ListNode left = mostUsed.prev;
            node.next = mostUsed;
            node.prev = left;
            left.next = node;
            mostUsed.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */