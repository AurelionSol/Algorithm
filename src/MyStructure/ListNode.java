package MyStructure;

public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }

    public static ListNode getNodeByNums(int[] nums) {

        ListNode head = new ListNode(-1);
        ListNode node = head;
        head.next = node;
        for (int i = 0; i < nums.length; i++) {
            node.next = new ListNode(nums[i]);
            node = node.next;
        }
        return head.next;
    }
}
