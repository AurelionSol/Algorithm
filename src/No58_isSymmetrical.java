import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class No58_isSymmetrical {
    public static void main(String[] args) {
        int[] nums = {8,6,6,5,7,7};
        TreeNode node = TreeNode.listNodeByNums(nums, 0);
        TreeNode node2 = TreeNode.listNodeByNums(nums, 0);
        System.out.println(isEqual(node, node2));
        System.out.println(isSymmetrical(node));
        System.out.println("Hello World");
    }

    static boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return true;
        return isEqual(pRoot.right, pRoot.left);
    }

    static boolean isEqual(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1==null||node2==null) return false;

        if (node1.val!=node2.val) return false;
        return isEqual(node1.left, node2.right) && isEqual(node1.right, node2.left);
    }
}
