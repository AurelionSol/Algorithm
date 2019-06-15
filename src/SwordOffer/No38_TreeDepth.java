package SwordOffer;

import java.util.ArrayList;

import static java.lang.Integer.max;
import MyStructure.TreeNode;
public class No38_TreeDepth {

    static ArrayList<ArrayList<Integer>> listList = new ArrayList<>();

    public static int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        No24_FindPath.GetPath(root, new ArrayList<>());

        int max = 0;
        for (ArrayList<Integer> list : listList) {
            if (list.size() > max) {
                max = list.size();
            }
        }
        return max;
    }

    //递归解法
    public static int TreeDepthRec(TreeNode root) {
        if (root == null) return 0;
        return max(1 + TreeDepth(root.left), 1 + TreeDepth(root.right));
    }


}
