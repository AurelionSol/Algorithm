import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.LinkedList;

public class No59_PrintZ {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        TreeNode node = TreeNode.listNodeByNums(nums, 0);
        PrintZ(node);
        System.out.println("Hello World");
    }

    public static ArrayList<ArrayList<Integer>> PrintZ(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> listTol = new ArrayList<>();
        ArrayList<TreeNode> listLeft = new ArrayList<>();
        ArrayList<TreeNode> listRight = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (pRoot == null) return listTol;
        queue.offer(pRoot);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
            listLeft.add(node);

        }
        queue.push(pRoot);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.right != null)
                queue.offer(node.right);
            if (node.left != null)
                queue.offer(node.left);
            listRight.add(node);
        }
        int depth = 2;
        int i = 1, j = 1;
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(pRoot.val);
        listTol.add(temp);
        while (i < listLeft.size() && j < listRight.size()) {
            temp = new ArrayList<>();
            int soldier = 0;
            if (depth % 2 == 1) {
                soldier = j;
                while (!listLeft.get(i).equals(listRight.get(soldier))) {
                    temp.add(listLeft.get(i).val);
                    j++;
                    i++;
                }
                temp.add(listRight.get(soldier).val);
            } else {
                soldier = i;
                while (!listRight.get(j).equals(listLeft.get(soldier))) {
                    temp.add(listRight.get(j).val);
                    j++;
                    i++;
                }
                temp.add(listLeft.get(soldier).val);
            }
            i++;
            j++;
            listTol.add(temp);
            depth++;
        }
        return listTol;
    }
}
