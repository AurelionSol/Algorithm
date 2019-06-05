package SwordOffer;

import java.util.Arrays;

public class No4_reConstructBinaryTree {


    public static void main(String[] args) {

        int pre[] = {1, 2, 4, 7, 3, 5, 6, 8};
        int in[] = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode node = reConstructBinaryTree(pre, in);
        System.out.println("OK");
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {

        TreeNode node;
        int len = pre.length;
        for (int i = 0; i < len; i++) {
            if (pre[0] == in[i]) {
                node = new TreeNode(pre[0]);
                int[] leftPre;
                leftPre = Arrays.copyOfRange(pre, 1, i + 1);
                int[] leftIn;
                leftIn = Arrays.copyOfRange(in, 0, i);
                node.left = reConstructBinaryTree(leftPre, leftIn);
                if (i < len) {
                    int[] rightPre;
                    rightPre = Arrays.copyOfRange(pre, i + 1, len);
                    int[] rightIn;
                    rightIn = Arrays.copyOfRange(in, i + 1, len);
                    node.right = reConstructBinaryTree(rightPre, rightIn);
                }
                return node;
            }
        }
        return null;
    }
}
