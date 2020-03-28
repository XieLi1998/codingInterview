
/*
 * [39] 平衡二叉树
 *
 * 题目:输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 *
 * 思路:1.递归
 *
 *
 *
 */


class Java_39 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public boolean IsBalanced_Solution(TreeNode root) {
        return TreeDepth(root) != -1;
    }

    public int TreeDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = TreeDepth(root.left);
        if (left == -1)
            return -1;
        int right = TreeDepth(root.right);
        if (right == -1)
            return -1;
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        Java_39 java_13 = new Java_39();
    }


}