public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    public static ListNode getNodeByNums(int[] nums){

        ListNode head=new ListNode(-1);
        ListNode node = head;
        head.next=node;
        for (int i = 0; i < nums.length; i++) {
           node.next= new ListNode(nums[i]);
           node=node.next;
        }
        return  head.next;
    }
}
