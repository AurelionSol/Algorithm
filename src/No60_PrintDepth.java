import java.util.ArrayList;


public class No60_PrintDepth {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> listTol = new ArrayList<>();
        if (pRoot == null) return listTol;
        int depth = TreeNode.depth(pRoot);
        for (int i = 1; i <= depth; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            levelOrder(pRoot, i, temp);
            listTol.add(temp);
        }
        return listTol;
    }

    void levelOrder(TreeNode node, int level, ArrayList list) {
        if (node == null || level < 1) {
            return;
        }

        if (level == 1) {
            list.add(node.val);
            return;
        }

        // 左子树
        levelOrder(node.left, level - 1, list);

        // 右子树
        levelOrder(node.right, level - 1, list);
    }
}
