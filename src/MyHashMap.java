import java.util.*;

public class MyHashMap<K, V> {
    private static final int DEFAULT_INIT_SIZE = 1 << 4;//初始容量为16
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;//默认装载因子0.75
    private Node[] table;//存储实际元素的数组
    private int size;//实际元素数量
    private int threshold;//当实际大小超过了临界值会进行扩容

    public MyHashMap() {
        table = new Node[DEFAULT_INIT_SIZE];
        threshold = (int) DEFAULT_LOAD_FACTOR * DEFAULT_INIT_SIZE;
        size = 0;
    }

    private int hash(K key) {
        return (key.hashCode() >>> 16) & (table.length - 1);
    }

    //返回值，不支持NULL，如果找不到返回NULL
    public V get(K key) {
        int index = hash(key);
        Node node = table[index];
        while (node != null) {
            if (node.getHash() == index && node.getKey().equals(key)) return (V) node.getValue();
            node = node.getNext();
        }
        return null;
    }

    public void put(K key, V value) {
        int index = hash(key);
        Node node = table[index];
        //如果已经有该key，则更新值
        while (node != null) {
            if (node.getHash() == index && node.getKey().equals(key)) {
                node.setValue(value);
                return;
            }
            node = node.getNext();
        }
        //否则插入新结点
        addNode(hash(key), key, value);
    }


    private void addNode(int hashCode, K key, V value) {
        Node node = new Node(hashCode, key, value, table[hashCode]);
        table[hashCode] = node;
        size++;
        if (size > threshold) {
            //如果超过门槛值，扩容
            reSize();
        }

    }

    //扩容，需要全部重新散列
    private void reSize() {
        Node[] newTable = new Node[table.length << 1];
        for (int i = 0; i < table.length; i++) {
            Node old = table[i];
            while (old != null) {
                Node next = old.next;
                int index = old.getHash() & (newTable.length - 1);
                old.setHash(index);
                old.setNext(newTable[index]);
                newTable[index] = old;
                old = next;
            }
            table = newTable;
            threshold = (int) (table.length * DEFAULT_LOAD_FACTOR);
        }
    }

    //内部结点类
    static class Node<K, V> {
        private int hashCode;
        private final K key;
        private V value;
        private Node<K, V> next;

        Node(int hashCode, K key, V value, Node node) {
            this.hashCode = hashCode;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        public final String toString() {
            return key.toString() + "=" + value.toString();
        }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public int getHash() {
            return hashCode;
        }

        public void setHash(int hash) {
            this.hashCode = hash;
        }

        public Node<K, V> getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public final boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj instanceof Node) {
                Node node = (Node) obj;
                if (node.key == this.key && node.value == this.value) return true;
            }
            return false;
        }

    }


}
