public class No25_RandomListClone {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead==null){
            return  null;
        }
        RandomListNode head = new RandomListNode(pHead.label);
        RandomListNode headRet = head;
        while (pHead != null) {
            RandomListNode next = null;
            RandomListNode random = null;
            if (pHead.next != null) {
                next = new RandomListNode(pHead.next.label);
                next.next = pHead.next.next;
                next.random = pHead.next.random;
            }

            if (pHead.random != null) {
                random = new RandomListNode(pHead.random.label);
                random.next = pHead.random.next;
                random.random = pHead.random.random;
            }

            head.next = next;
            head.random = random;
            head = head.next;
            pHead = pHead.next;
        }
        return headRet;
    }
}
