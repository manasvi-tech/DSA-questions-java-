
public class App {
    public static void main(String[] args) throws Exception {
        LRUCache cache = new LRUCache(3);
        cache.put(1, 10);
        cache.put(2, 20);
        cache.put(3, 30);
        System.out.println("Value for key 2: " + cache.get(2));
        cache.put(4, 40); // This should evict key 1 if capacity is 3
        System.out.println("Value for key 1 (should be null or -1): " + cache.get(1));
    }
}
