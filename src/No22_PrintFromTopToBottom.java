import java.util.ArrayList;
import java.util.LinkedList;

public class No22_PrintFromTopToBottom {
    public static void main(String[] args) {
        int[] nums={10,6,14,4,8,12,16};
        TreeNode node = TreeNode.listNodeByNums(nums,0);
        ArrayList<Integer> list = PrintFromTopToBottom(node);
        System.out.println("Hello World!");
    }
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if (root==null){
            return list;
        }
        do {
            queue.poll();
            if (root.left != null) {
                queue.add(root.left);
            }
            if (root.right != null) {
                queue.add(root.right);
            }
            list.add(root.val);
            root = queue.peek();
        } while (!queue.isEmpty());
        return  list;

    }


}
