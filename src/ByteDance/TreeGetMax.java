package ByteDance;

import MyStructure.TreeNode;

public class TreeGetMax {
    private int ret = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getMax(root);
        return ret;
    }

    public int getMax(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, getMax(node.left));
        int right = Math.max(0, getMax(node.right));
        ret = Math.max(ret, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
}
