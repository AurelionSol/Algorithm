package SwordOffer;

import java.util.ArrayList;
import MyStructure.TreeNode;
public class No17_HasSubtree {

    public static void main(String[] args) {
        int[] nums1 = {8, 8, -1, 9, -1, -1, -1, 2, -1, -1, -1, -1, -1, -1, -1, 5};
        int[] nums2 = {8, 9, -1, 2};
        int[] nums3 = {8, 9, -1, 2, -1, -1, -1, 5};
        TreeNode root1 = TreeNode.listNodeByNums(nums1, 0);
        TreeNode root2 = TreeNode.listNodeByNums(nums2, 0);
        TreeNode root3 = TreeNode.listNodeByNums(nums3, 0);
        System.out.println(HasSubtree(root1, root2));
        System.out.println(isEqual(root3, root2));
        System.out.println();
    }

    public static boolean isEqual(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2 == null;
        }
        if (root2 == null) {
            return true;
        }
        if (root1.val == root2.val) {
            return isEqual(root1.left, root2.left) && isEqual(root1.right, root2.right);
        } else {
            return false;
        }

    }

    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        if (isEqual(root1.left, root2) || isEqual(root1.right, root2)) {
            return true;
        } else {
            return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
        }

    }

//    static ArrayList<Integer> preList1 = new ArrayList<>();
//    static ArrayList<Integer> inList1 = new ArrayList<>();
//
//    static ArrayList<Integer> preList2 = new ArrayList<>();
//    static ArrayList<Integer> inList2 = new ArrayList<>();
//
//    public static boolean HasSubtree(MyStructure.TreeNode root1, MyStructure.TreeNode root2) {
//        preOrder(root1, preList1);
//        preOrder(root1, preList2);
//        inOrder(root1, inList1);
//        inOrder(root1, inList2);
//
//
//        return isChild(preList1,preList2)&&isChild(inList1,inList2);
//    }
//
//    public static void preOrder(MyStructure.TreeNode node, ArrayList<Integer> preList) {
//        if (node == null)              //判断节点是否为空
//        {
//            return;
//        }
//        preList.add(node.val);
//        preOrder(node.left, preList);
//        preOrder(node.right, preList);
//    }
//
//    public static void inOrder(MyStructure.TreeNode node, ArrayList<Integer> inList) {
//        if (node == null)              //判断节点是否为空
//        {
//            return;
//        }
//        preOrder(node.left, inList);
//        inList.add(node.val);
//        preOrder(node.right, inList);
//    }
//
//    public static boolean isChild(ArrayList<Integer> list1, ArrayList<Integer>list2) {
//        boolean flag = false;
//        for (int i = 0; i < list1.size(); i++) {
//            if (list1.get(i).equals(list2.get(0))) {
//                flag = true;
//                for (int j = 0; j < list2.size(); j++) {
//                    if (!list1.get(i + j).equals(list2.get(j))) {
//                        flag = false;
//                        break;
//                    }
//                }
//            }
//        }
//        return flag;
//    }
}
