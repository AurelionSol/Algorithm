public class No46_LastRemaining_Solution {
    public static void main(String[] args) {
        System.out.println(LastRemaining_Solution(0, 0));
        System.out.println("Hello World");
    }

    //从下往上，f[i]=(f[i-1]+m)%i;  (i>1)
    public static int LastRemaining_SolutionInduct(int n, int m) {
        if (n == 0 || m == 0)
            return -1;
        int last = 0;
        for (int i = 2; i <= n; i++)
            last = (last + m) % i;
        return last;
    }


    //链表法
    public static int LastRemaining_Solution(int n, int m) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i;
        }
        ListNode node = ListNode.getNodeByNums(nums);
        ListNode pre = node;
        while (pre.next != null) {
            pre = pre.next;
        }
        pre.next = node;
        int temp = m;
        while (n > 1) {
            if (temp == 0) {
                pre.next = node.next;
                node = pre.next;
                n--;
                temp = m;
                continue;
            }
            temp--;
            node = node.next;
            pre = pre.next;
        }
        return pre.val;
    }

}
