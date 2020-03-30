
/*
 * [62] 二叉搜索树的第k个结点
 *
 * 题目:给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）
 *      中，按结点数值大小顺序第三小结点的值为4
 *
 *
 * 思路:1.利用搜索二叉树的特性，进行中序遍历
 *
 *
 *
 *
 *
 */


import java.util.ArrayList;

class Java_62 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }


    ArrayList<TreeNode> list = new ArrayList<>();
    TreeNode KthNode(TreeNode pRoot, int k) {
        addNode(pRoot);

        if (k >= 1 && list.size() >= k) {
            return list.get(k - 1);
        }
        return null;
    }

    void addNode(TreeNode pRoot) {
        if (pRoot != null) {
            addNode(pRoot.left);
            list.add(pRoot);
            addNode(pRoot.right);
        }
    }

    public static void main(String[] args) {
        Java_62 java_49 = new Java_62();
    }


}