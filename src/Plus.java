public class Plus {
    public static void main(String[] args) {
        Plus main = new Plus();
        int[] a = {1, 2, 3};
        int[] b = {3,2,1,10};
        ListNode aNode = ListNode.getNodeByNums(a);
        ListNode bNode = ListNode.getNodeByNums(b);
        ListNode ans = main.plusAB(aNode, bNode);
        System.out.println();

    }


    public ListNode plusAB(ListNode a, ListNode b) {
        // write code here
        if(a==null&&b==null) return  null;
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        while (a != null && b != null) {
            int sum = a.val + b.val;
            temp.next = new ListNode(sum);
            temp = temp.next;
            a = a.next;
            b = b.next;
        }
        if (a != null) {
            temp.next = a;
        }
        if (b != null) {
            temp.next = b;
        }
        ListNode pre = new ListNode(-1);
        head = head.next;
        while (head != null) {
            ListNode now = new ListNode(head.val);
            now.next=pre.next;
            pre.next = now;
            head = head.next;
        }
        return pre.next;
    }
}
