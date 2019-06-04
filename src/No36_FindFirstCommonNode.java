import java.util.List;

public class No36_FindFirstCommonNode {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 6, 7};
        int[] nums2 = {4, 5, 6, 7};
        ListNode pHead1 = ListNode.getNodeByNums(nums1);
        ListNode pHead2 = ListNode.getNodeByNums(nums2);
        ListNode commonNode = FindFirstCommonNode(pHead1, pHead2);
        System.out.println("Hello World!");
    }

    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int len1 = 0, len2 = 0;
        ListNode h1 = new ListNode(-1);
        h1.next = pHead1;
        ListNode h2 = new ListNode(-1);
        h2.next = pHead2;
        while (pHead1 != null) {
            pHead1 = pHead1.next;
            len1++;
        }
        while (pHead2 != null) {
            pHead2 = pHead2.next;
            len2++;
        }
        h1=h1.next;
        h2=h2.next;
        while (h1 != null && h2 != null) {
            if (len1 == len2) {
                if (h1.val == h2.val) {
                    return h1;
                }
                h1 = h1.next;
                h2 = h2.next;
            }
            if (len1 > len2) {
                h1 = h1.next;
                len1--;
            }
            if (len1 < len2) {
                h2 = h2.next;
                len2--;
            }
        }
        return null;
    }
}
