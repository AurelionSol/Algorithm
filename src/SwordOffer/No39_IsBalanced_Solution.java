package SwordOffer;

import java.util.ArrayList;

import static java.lang.Integer.max;

public class No39_IsBalanced_Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, -1, -1, 6};
        TreeNode node = TreeNode.listNodeByNums(nums, 0);
        System.out.println(IsBalanced_Solution(node));
        System.out.println("Hello World!");
    }

    public static boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) return true;
        int leftDepth = TreeDepthRec(root.left);
        int rightDepth = TreeDepthRec(root.right);
        return Math.abs(leftDepth - rightDepth) < 1;
    }

    public static int TreeDepthRec(TreeNode root) {
        if (root == null) return 0;
        return Math.max(1 + TreeDepthRec(root.left), 1 + TreeDepthRec(root.right));
    }
}
