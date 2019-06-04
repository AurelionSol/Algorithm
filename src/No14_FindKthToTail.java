public class No14_FindKthToTail {
    public static void main(String[] args) {

        System.out.println("Hello World!");
    }
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode Kth=head;
        for (int i = 0; i <k ; i++) {
            if (Kth==null) return null;
            Kth=Kth.next;
        }
        while (Kth!=null){
            head=head.next;
            Kth=Kth.next;
        }
        return  head;
    }
}
