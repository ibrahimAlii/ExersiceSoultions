package IntroductionToJavaProgramming.chapter28_hashing;

import java.util.Set;

public interface Map<K, V> {

    /* Remove all entries from this map */
    void clear();

    /* Return true if the map contains an entry fot the specified key */
    boolean containsKey(K key);

    /* Return true if the map contains one or more keys to the specified values */
    boolean containsValue(V value);

    /* Return a set consisting of the entries in this map */
    Set<Entry<K, V>> entrySet();

    /* Return a value for the specified key */
    V get(K key);

    /* Return true if the map contains no mappings */
    boolean isEmpty();

    /* Return a set consisting of the keys in the map */
    Set<K> keySet();

    /* Puts a mapping in the map */
    V put(K key, V value);

    /* Removes the entries for the specified keys */
    void remove(K key);

    /* Return the number of mappings in this map */
    int size();

    /* Return a set consisting of the values in this map */
    Set<V> values();
}
