class ListNode{
    int key, val;
    ListNode next;
    public ListNode(int key, int val, ListNode next){
        this.key = key;
        this.val = val;
        this.next = next;
    }
}
public class MyHashMap {
    ListNode[] data;
    int size = 1000;
    
    public MyHashMap() {
        this.data = new ListNode[size];
    }
    
    public void put(int key, int value) {
        remove(key);
        int h = hash(key);
        ListNode node = new ListNode(key,value,data[h]);
        data[h] = node;
    }
    
    public int get(int key) {
        int h = hash(key);
        ListNode node = data[h];
        while(node!=null){
            if(node.key == key) return node.val;
            node = node.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        int h = hash(key);
        ListNode node = data[h];
        if(node==null) return;
        if(node.key==key) data[h] = node.next;
        else {
            while(node.next!=null){
                if(node.next.key == key){
                    node.next = node.next.next;
                    System.out.println("Entered");
                    return;
                }
                node = node.next;
            }
        }
    }
    public int hash(int key){
        return (key%size);
    }
}

