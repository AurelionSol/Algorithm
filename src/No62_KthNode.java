import java.util.ArrayList;
import java.util.HashMap;

//直接中序遍历即可
public class No62_KthNode {
    public static void main(String[] args) {
        int[] nums = {8, 6, 10, 5, 7, 9, 11};
        TreeNode node = TreeNode.listNodeByNums(nums, 0);

        System.out.println(KthNode(node, 5).val);
        System.out.println("Hello World");
    }

    static int index = 0;
    static TreeNode node;

    static TreeNode KthNode(TreeNode pRoot, int k) {
        getKthNode(pRoot,k);
        return node;
    }

    static void getKthNode(TreeNode pRoot, int k) {
        if (pRoot == null) return;
        KthNode(pRoot.left, k);
        index++;
        if (index == k) {
            node = pRoot;
        }
        KthNode(pRoot.right, k);
    }


}
