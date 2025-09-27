
public class App {

    public static void main(String[] args) throws Exception {
        LFUCache cache = new LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // returns 1
        cache.put(3, 3); // evicts key 2
        System.out.println(cache.get(2)); // returns -1 (not found)
        System.out.println(cache.get(3)); // returns 3
        cache.put(4, 4); // evicts key 1
        System.out.println(cache.get(1)); // returns -1 (not found)
        System.out.println(cache.get(3)); // returns 3
        System.out.println(cache.get(3)); // returns 3
        LFUCache lfu = new LFUCache(2);
        lfu.put(10, 100);
        lfu.put(20, 200);
        System.out.println(lfu.get(10)); // Output: 100
        lfu.put(30, 300); // Should evict key 20
        System.out.println(lfu.get(20)); // Output: -1
        System.out.println(lfu.get(30)); // Output: 300
        lfu.put(40, 400); // Should evict key 10
        System.out.println(lfu.get(10)); // Output: -1
        System.out.println(lfu.get(30)); // Output: 300
        System.out.println(lfu.get(40)); // Output: 400
    }
}
