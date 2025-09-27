import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

class ListNode {
    int key;
    int val;
    int freq;

    ListNode(int key, int val, int freq) {
        this.key = key;
        this.val = val;
        this.freq = freq;
    }

}
public class LFUCache {

    Map<Integer, ListNode> keyToNode;
    // will trck the last used on its own there will be no random order
    Map<Integer, LinkedHashSet<ListNode>> freqToSet;
    int min;
    int size;
    int curr = 0;

    public LFUCache(int capacity) {
        keyToNode = new HashMap<>();
        freqToSet = new HashMap<>();
        min = 0;
        size = capacity;
    }

    public int get(int key) {
        if (!keyToNode.containsKey(key))
            return -1;

        ListNode node = keyToNode.get(key);
        int freq = node.freq;
        int value = node.val;

        // Remove node from current frequency set
        LinkedHashSet<ListNode> set = freqToSet.get(freq);
        set.remove(node);

        // If set is empty and freq was min, update min
        if (set.isEmpty() && freq == min) {
            min = freq + 1;
        }

        // Increase node's frequency
        node.freq++;

        // Add node to new frequency set
        freqToSet.computeIfAbsent(node.freq, k -> new LinkedHashSet<>());
        freqToSet.get(node.freq).add(node);

        return value;
    }

    public void put(int key, int value) {
        if (keyToNode.containsKey(key)) {
            ListNode node = keyToNode.get(key);
            node.val = value;
            int freq = node.freq;
            node.freq++;

            //removing and ading to +1 frequency
            LinkedHashSet<ListNode> set = freqToSet.get(freq);
            set.remove(node);

            // If set is empty and freq was min, update min
            if (set.isEmpty() && freq == min) {
                min = freq + 1;
            }

            // Add node to new frequency set
            freqToSet.computeIfAbsent(node.freq, k -> new LinkedHashSet<>());
            freqToSet.get(node.freq).add(node);

        } else {
            if (curr == size) {
                LinkedHashSet<ListNode> set = freqToSet.get(min);
                ListNode firstNode = set.iterator().next();
                set.remove(firstNode);
                keyToNode.remove(firstNode.key);
                curr--;
            }

            ListNode node = new ListNode(key, value, 1);
            min = 1;

            freqToSet.computeIfAbsent(node.freq, k -> new LinkedHashSet<>());
            freqToSet.get(node.freq).add(node);

            keyToNode.put(key,node);
            curr++;
        }
    }
}
