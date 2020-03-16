
/*
 * [26] 二叉搜索树与双向链表
 *
 * 题目:输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 *      要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 *
 *
 * 思路:1.递归实现
 *      2.递归实现_pro,更好理解版
 *          1.将左子树构造成双链表，并返回链表头节点。
 *          2.定位至左子树双链表最后一个节点。
 *          3.如果左子树链表不为空的话，将当前root追加到左子树链表。
 *          4.将右子树构造成双链表，并返回链表头节点。
 *          5.如果右子树链表不为空的话，将该链表追加到root节点之后。
 *          6.根据左子树链表是否为空确定返回的节点。
 *      3.非递归实现
 *          1.核心是中序遍历的非递归算法。
 *          2.修改当前遍历节点与前一遍历节点的指针指向。
 *
 *
 *
 *
 */


class Java_26 {


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    TreeNode head = null;
    TreeNode realhead = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        ConvertHelper(pRootOfTree);
        return realhead;
    }

    public void ConvertHelper(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return;
        }
        ConvertHelper(pRootOfTree.left);
        if (head == null) {
            head = pRootOfTree;
            realhead = pRootOfTree;
        } else {
            head.right = pRootOfTree;
            pRootOfTree.left = head;
            head = pRootOfTree;
        }
        ConvertHelper(pRootOfTree.right);
    }

    //2.递归实现_pro,更好理解版
    public TreeNode Convert_02(TreeNode root) {
        if (root == null)
            return null;
        if (root.left == null && root.right == null)
            return root;

        TreeNode left = Convert_02(root.left);
        TreeNode p = left;

        while (p != null && p.right != null) {
            p = p.right;
        }

        if (left != null) {
            p.right = root;
            root.left = p;
        }

        TreeNode right = Convert_02(root.right);
        if (right != null) {
            root.right = right;
            right.left = root;
        }

        return left == null ? root : left;

    }

    //3.非递归实现
    public TreeNode Convert_03(TreeNode root) {
        return null;
    }

    public static void main(String[] args) {
        Java_26 java_13 = new Java_26();
    }


}