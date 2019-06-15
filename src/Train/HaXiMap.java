package Train;

import java.util.HashMap;
import java.util.LinkedList;

public class HaXiMap {
    public static void main(String args[]) {
        HaXiMap map = new HaXiMap();
        for (int i = 0; i < 100; i++) {
            String key = "" + (int) (Math.random() * 1000);
            int value = (int) (Math.random() * 1000);
            map.put(key, value);
        }
        System.out.println(map);
    }

    Node[] data;
    int size;
    double factor;


    public HaXiMap() {
        this.data = new Node[16];
        size = 0;
        factor = 0.75;
    }

    public void put(String key, int value) {
        Node node = new Node(key, value);
        int code = hash(key);
        Node now = data[code];
        if (now != null) {
            if (now.key.equals(key)) {
                now.value = value;
                return;
            }
            while (now.next != null) {
                now = now.next;
            }
            now.next = node;
        } else {
            data[code] = node;
        }
        if (++size >= data.length * factor) {
            reSize();
        }

    }

    public int get(String key) {
        int code = hash(key);
        Node node = data[code];
        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        return -1;
    }

    public void reSize() {
        size = 0;
        Node[] oldData = data;
        data = new Node[oldData.length * 2];
        for (int i = 0; i < oldData.length; i++) {
            Node node = oldData[i];
            while (node != null) {
                put(node.key, node.value);
                node = node.next;
            }
        }

    }

    public int hash(String key) {

        return (key.hashCode() >>> 16 ^ key.hashCode()) & (data.length - 1);
    }


    private class Node {
        String key;
        int value;
        Node next;

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
}
