import java.util.ArrayList;
import java.util.HashMap;

public class No55_EntryNodeOfLoop {
    HashMap<ListNode, Integer> map = new HashMap<>();

    //快慢指针法
    public ListNode EntryNodeOfLoopFAS(ListNode pHead) {
        if (pHead == null || pHead.next == null || pHead.next.next == null) return null;
        ListNode fast = pHead.next.next;
        ListNode slow = pHead.next;
        while (fast != slow) {
            if (fast == null || slow == null) return null;
            else {
                fast = fast.next.next;
                slow = slow.next;
            }
        }
        fast = pHead;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    //hash法
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) return null;

        while (true) {
            if (pHead == null) return null;
            if (map.containsKey(pHead))
                return pHead;
            map.put(pHead, 1);
            pHead = pHead.next;

        }
    }
}
