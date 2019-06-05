package SwordOffer;

import java.util.ArrayList;
import java.util.Collections;

public class No24_FindPath {
    public static void main(String[] args) {
        int[] nums = {10, 5, 12, 4, 7};
        TreeNode node = TreeNode.listNodeByNums(nums, 0);
        listList = FindPath(node, 22);
//        System.out.println("Hello World!");
    }

    static ArrayList<ArrayList<Integer>> listList = new ArrayList<>();

    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return listList;
        }
        GetPath(root, new ArrayList<>());

        int count = 0;
        while (count < listList.size()) {
            ArrayList<Integer> list = listList.get(count);
            int sum = 0;
            for (int j = 0; j < list.size(); j++) {
                sum += list.get(j);
            }
            if (sum != target) {
                listList.remove(list);
            } else {
                count++;
            }
        }
        return listList;
    }

    public static void GetPath(TreeNode root, ArrayList<Integer> list) {

        if (root.left == null && root.right == null) {
            list.add(root.val);
            listList.add(list);
        }
        if (root.left != null) {
            ArrayList<Integer> childList = new ArrayList<>(list);
            childList.add(root.val);
            GetPath(root.left, childList);
        }
        if (root.right != null) {
            ArrayList<Integer> childList = new ArrayList<>(list);
            childList.add(root.val);
            GetPath(root.right, childList);
        }

    }
}
