package SwordOffer;

public class No26_TreeConvertList {
    public static void main(String[] args) {
        int[] nums = {4, 3, -1, 2, -1, -1, -1, 1};
        TreeNode node = TreeNode.listNodeByNums(nums, 0);
        node = Convert(node);
        System.out.println("Hello World!");
    }

    public static TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        trans(pRootOfTree, pRootOfTree.left, true);
        trans(pRootOfTree, pRootOfTree.right, false);
        while (pRootOfTree.left != null) {
            pRootOfTree = pRootOfTree.left;
        }
        return pRootOfTree;
    }

    public static void trans(TreeNode parent, TreeNode node, boolean isLeft) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            if (isLeft) node.right = parent;
            else node.left = parent;
        }

        if (node.left != null) {
            if (isLeft) {
                if (node.right != null) {
                    node.right.left = node;
                    node.right.right = parent;
                    parent.left = node.right;
                } else {
                    node.right = parent;
                }
                trans(node, node.left, true);
            }
        }
        if (node.right != null) {
            if (!isLeft) {
                if (node.left != null) {
                    node.left.right = node;
                    node.left.left = parent;
                    parent.right = node.left;
                } else {
                    node.left = parent;
                }
                trans(node, node.right, false);
            }
        }
    }
}
