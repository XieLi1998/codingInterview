
/*
 * [58] 对称的二叉树
 *
 * 题目:请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的
 *
 *
 * 思路:1.
 *
 *
 *
 *
 */


class Java_58 {

    public class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }


    boolean isSymmetrical(TreeNode pRoot) {
        return pRoot == null || judg(pRoot.left, pRoot.right);
    }

    public boolean judg(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null) {
            return false;
        }

        if (node1.val != node2.val) {
            return false;
        }else {
            return judg(node1.left,node2.right) && judg(node1.right,node2.left);
        }
    }

    public static void main(String[] args) {
        Java_58 java_57 = new Java_58();
    }


}