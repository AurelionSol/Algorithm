public class No57_GetNext {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) return null;
        if (pNode.left == null && pNode.right == null && pNode.next == null) return null;
        if (pNode.left == null && pNode.right == null) {
            if (pNode == pNode.next.left) return pNode.next;
            else {
                while (pNode.next != null) {
                    if (pNode.next.next == null) return null;
                    if (pNode.next == pNode.next.next.right) {
                        pNode = pNode.next;
                    } else return pNode.next.next;
                }
            }
        }

        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        } else if (pNode.next != null) return pNode.next;
        else {
            return null;
        }

    }
}
