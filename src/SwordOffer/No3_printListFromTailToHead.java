package SwordOffer;

import MyStructure.ListNode;

import java.util.ArrayList;
import java.util.Collections;

public class No3_printListFromTailToHead {



    public static void main(String[] args) {
        ListNode listNode = new ListNode(67);
        listNode.next = new ListNode(0);
        listNode.next.next = new ListNode(24);
        listNode.next.next.next = new ListNode(58);
        System.out.println(printListFromTailToHead(listNode).toString());
    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        listNode = reverseList(listNode);
        while (listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }

        return list;
    }

    public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        while (listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }
        Collections.reverse(list);
        return list;
    }

    public static ListNode reverseList(ListNode listNode) {
        if (listNode == null) {
            return null;
        }
        ListNode currentNode, prevNode, nextNode;
        prevNode = null;
        currentNode = listNode;
        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            if (nextNode == null) {
                return currentNode;
            }
            prevNode = currentNode;
            currentNode = nextNode;
        }
        return null;
    }
}
