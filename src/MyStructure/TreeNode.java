package MyStructure;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static void main(String[] args) {
        int[] nums = {8, 8, 7, 9, 2, -1, -1, -1, -1, 4, 7};
        TreeNode tree = listNodeByNums(nums, 0);
        System.out.println("Hello World!");
    }

    public static TreeNode listNodeByNums(int[] nums, int index) {
        if (index >= nums.length) {
            return null;
        }
        if (nums[index] == -1) {
            return null;
        }
        TreeNode head = new TreeNode(nums[index]);
        head.left = listNodeByNums(nums, 2 * index + 1);
        head.right = listNodeByNums(nums, 2 * index + 2);
        return head;
    }

    public static int getNodeNum(TreeNode node) {
        int count = 0;
        if (node != null) {
            count++;   //根结点加1
            count = count + getNodeNum(node.left);  //加上左子树结点数
            count = count + getNodeNum(node.right);   //加上右子树结点数
        }
        return count;


    }

    public static int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int l = depth(node.left);
        int r = depth(node.right);
        if (l > r) {
            return l + 1;
        } else {
            return r + 1;
        }
    }
}
