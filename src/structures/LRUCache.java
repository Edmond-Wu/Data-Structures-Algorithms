package structures;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU Cache is a least-recently-used cache
 * If the cache exceeds capacity when something is put into it, the least-recently-accessed item is removed
 */
public class LRUCache extends LinkedHashMap<Integer, Integer> {
    private final int CAPACITY;

    public LRUCache(int capacity) {
        super(capacity, .75F, true);
        this.CAPACITY = capacity;
    }

    /**
     * Puts a key-value pair into the cache
     * @param key key
     * @param value value
     */
    public void put(int key, int value) {
        super.put(key, value);
    }

    /**
     * Returns the value associated with a key, or -1 if the key doesn't exist in the cache
     * @param key integer key to retrieve the value
     * @return value associated with the key, or -1 if the key is not present
     */
    public Integer get(int key) {
        return this.getOrDefault(key, -1);
    }

    /**
     * Boolean method to determine whether to remove the oldest/least-recently-used item
     * Call if the cache's size exceeds capacity
     * @param eldest eldest entry in cache
     * @return true if needs to be removed, false otherwise
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return this.size() > CAPACITY;
    }
}
