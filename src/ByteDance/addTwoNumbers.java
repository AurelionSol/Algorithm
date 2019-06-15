package ByteDance;

import MyStructure.ListNode;

public class addTwoNumbers {
    public static void main(String args[]) {
        addTwoNumbers z = new addTwoNumbers();
        ListNode l1 = ListNode.getNodeByNums(new  int[]{7,2,4,3});
        ListNode l2 = ListNode.getNodeByNums(new  int[]{5,6,4});
        ListNode temp = z.f(l1,l2);
        System.out.println();
    }
    public ListNode f(ListNode l1, ListNode l2) {
        StringBuilder s1 = listNodeToString(l1);
        StringBuilder s2 = listNodeToString(l2);
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 > len2) {
            s2 = addZero(s2, len1 - len2);
        } else if (len1 < len2) {
            s1 = addZero(s1, len2 - len1);
        }
        int len = s1.length();
        boolean flag = false;
        StringBuilder res = new StringBuilder(s1);
        for (int i = s1.length() - 1; i >= 0; i--) {
            int ans = (s1.charAt(i) - '0') + (s2.charAt(i) - '0');
            if (flag) {
                ans++;
            }
            res.setCharAt(i, (char) (ans % 10 + '0'));
            flag = ans >= 10;
        }
        if (flag) {
            res.insert(0, 1);
        }
        ListNode result = new ListNode(-1);
        ListNode tempNode = result;
        for (int i = 0; i < res.length(); i++) {
            tempNode.next = new ListNode(res.charAt(i)-'0');
            tempNode = tempNode.next;
        }
        return result.next;
    }

    public StringBuilder listNodeToString(ListNode l) {
        StringBuilder s = new StringBuilder();
        while (l != null) {
            s.append(l.val);
            l = l.next;
        }
        return s;
    }

    public StringBuilder addZero(StringBuilder s, int len) {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < len; i++) {
            temp.append(0);
        }
        return s.insert(0, temp);
    }
}
