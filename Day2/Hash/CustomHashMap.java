package Hash;


import java.util.LinkedList;

class Entry<K, V> {
    K key;
    V value;
    Entry<K, V> next;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

public class CustomHashMap<K, V> {

    private static final int DEFAULT_CAPACITY = 16;
    private LinkedList<Entry<K, V>>[] table;
    private int size;

    public CustomHashMap() {
        this(DEFAULT_CAPACITY);
    }

    public CustomHashMap(int capacity) {
        table = new LinkedList[capacity];
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int getBucketIndex(K key) {
        if (key == null) {
            return 0;
        }
        return Math.abs(key.hashCode() % table.length);
    }

    public void put(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        if (table[bucketIndex] == null) {
            table[bucketIndex] = new LinkedList<>();
        }

        LinkedList<Entry<K, V>> bucket = table[bucketIndex];
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }

        bucket.add(new Entry<>(key, value));
        size++;
    }

    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        if (table[bucketIndex] != null) {
            LinkedList<Entry<K, V>> bucket = table[bucketIndex];
            for (Entry<K, V> entry : bucket) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
        }
        return null;
    }

    public V remove(K key) {
        int bucketIndex = getBucketIndex(key);
        if (table[bucketIndex] != null) {
            LinkedList<Entry<K, V>> bucket = table[bucketIndex];
            Entry<K, V> previous = null;
            for (Entry<K, V> current : bucket) {
                if (current.key.equals(key)) {
                    V removedValue = current.value;
                    if (previous == null) {
                        bucket.removeFirst();
                    } else {
                        previous.next = current.next;
                    }
                    size--;
                    return removedValue;
                }
                previous = current;
            }
        }
        return null;
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("apple", 1);
        map.put("banana", 2);
        map.put("cherry", 3);

        System.out.println("Size: " + map.size());
        System.out.println("Is empty: " + map.isEmpty());
        System.out.println("Get apple: " + map.get("apple"));
        System.out.println("Get banana: " + map.get("banana"));
        System.out.println("Contains key apple: " + map.containsKey("apple"));
        System.out.println("Contains key grape: " + map.containsKey("grape"));

        map.put("apple", 10);
        System.out.println("Get apple after update: " + map.get("apple"));

        System.out.println("Remove banana: " + map.remove("banana"));
        System.out.println("Size after remove: " + map.size());
        System.out.println("Get banana after remove: " + map.get("banana"));
        System.out.println("Contains key banana: " + map.containsKey("banana"));
    }
}

