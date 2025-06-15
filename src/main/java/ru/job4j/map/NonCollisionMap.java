package ru.job4j.map;

import java.util.*;

public class NonCollisionMap<K, V> implements SimpleMap<K, V> {
    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;
    private int count = 0;
    private int modCount = 0;
    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        if (count >= capacity * LOAD_FACTOR) {
            expand();
        }
        int index = indexFor(hash(Objects.hashCode(key)));
        MapEntry<K, V> x = table[index];
        if (x == null) {
            table[index] = new MapEntry<>(key, value);
            modCount++;
            count++;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public V get(K key) {
        if (find(key) != -1) {
            return table[find(key)].value;
        }
        return null;
    }

    @Override
    public boolean remove(K key) {
        if (find(key) != -1) {
            table[find(key)] = null;
            modCount++;
            count--;
            return true;
        }
        return false;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<>() {
            int c = modCount;
            int index = 0;

            @Override
            public boolean hasNext() {
                if (c != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (index < table.length && table[index] == null) {
                    index++;
                }
                return index < table.length;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[index++].key;
            }
        };
    }

    private int find(K key) {
        int hashCode = Objects.hashCode(key);
        int index = indexFor(hash(hashCode));
        if (table[index] != null) {
            if (Objects.hashCode(table[index].key) == hashCode) {
                if (Objects.equals(table[index].key, key)) {
                    return index;
                }
            }
        }
        return -1;
    }

    private int hash(int hashCode) {
        return hashCode ^ (hashCode >>> 16);
    }

    private int indexFor(int hash) {
        return  hash & (capacity - 1);
    }

    private void expand() {
        MapEntry<K, V>[] newTable = new MapEntry[capacity * 2];
        capacity = capacity * 2;
        for (MapEntry<K, V> kvMapEntry : table) {
            if (kvMapEntry != null) {
                int newIndex = indexFor(hash(Objects.hashCode(kvMapEntry.key)));
                newTable[newIndex] = new MapEntry<>(kvMapEntry.key, kvMapEntry.value);
            }
        }
        table = newTable;
    }

    private static class MapEntry<K, V> {
        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        NonCollisionMap<String, Integer> map = new NonCollisionMap<>();
        System.out.println(map.hash(0));
        System.out.println(map.hash(65535));
        System.out.println(map.hash(65536));
        System.out.println(map.indexFor(0));
        System.out.println(map.indexFor(7));
        System.out.println(map.indexFor(8));
    }
}
