package SwordOffer;

import MyStructure.ListNode;

public class No56_deleteDuplication {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1, 1};
        ListNode node = ListNode.getNodeByNums(nums);
        ListNode dD = deleteDuplication(node);
        System.out.println("Hello World");
    }

    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) return pHead;
        ListNode pre = pHead;
        ListNode prePre = new ListNode(-1);
        ListNode temp = prePre;
        prePre.next = pre;
        pHead = pHead.next;
        while (pHead != null) {
            boolean isDup = false;
            while (pHead != null && pre.val == pHead.val) {
                isDup = true;
                pre.next = pHead.next;
                pHead = pHead.next;
            }
            if (isDup) {
                prePre.next = pre.next;
                pre = prePre.next;
                if (pHead != null) pHead = pHead.next;
            } else {
                prePre = prePre.next;
                pre = pre.next;
                pHead = pHead.next;
            }

        }
        return temp.next;
    }
}
