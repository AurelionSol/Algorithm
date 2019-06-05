package LeetCode;

import MyStructure.ListNode;

public class rehashing {
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        int newCapacity = hashTable.length * 2;
        ListNode[] newHashTable = new ListNode[newCapacity];
        for (int i = 0; i < hashTable.length; i++) {
            ListNode node = hashTable[i];
            while (node != null) {
                ListNode temp = new ListNode(node.val);
                int code = hashcode(temp.val, newCapacity);
                ListNode head = newHashTable[code];
                if (head == null) newHashTable[code] = temp;
                else {
                    while (head.next != null) {
                        head = head.next;
                    }
                    head.next = temp;
                }
                node = node.next;
            }
        }
        return newHashTable;
    }

    int hashcode(int key, int capacity) {
        return key % capacity;
    }
}
