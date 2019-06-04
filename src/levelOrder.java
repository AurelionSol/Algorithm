import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class levelOrder {

    public static void main(String[] args) {
        levelOrder main = new levelOrder();
        int[] a = {1,2,3};
        TreeNode node= TreeNode.listNodeByNums(a,0);
        System.out.println(main.levelOrder(node));

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> totList = new ArrayList();
        TreeNode flag = root;
        LinkedList<TreeNode> deque = new LinkedList();
        deque.offerLast(root);
        List<Integer> list = new ArrayList();
        while (!deque.isEmpty()) {
            TreeNode temp = deque.peekFirst();
            if(temp.left!=null) deque.offerLast(temp.left);
            if(temp.right!=null) deque.offerLast(temp.right);
            list.add(temp.val);
            if (temp == flag) {
                totList.add(list);
                list = new ArrayList();
                flag = deque.peekLast();
            }
            deque.pollFirst();
        }
        return totList;
    }
}
