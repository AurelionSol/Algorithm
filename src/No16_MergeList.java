import java.util.List;

public class No16_MergeList {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(5);
        listNode1.next.next.next = new ListNode(7);
        ListNode listNode2 = null;
        System.out.println(Merge(listNode1,listNode2));
        System.out.println("OK");
    }

    public static  ListNode Merge(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                head.next = list1;
                list1 = list1.next;
            } else {
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
        }
        if (list1 != null) {
            head.next = list1;
        }
        if (list2 != null) {
            head.next = list2;
        }
        return  temp.next;
    }
}
