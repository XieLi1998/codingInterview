
/*
 * [61] 序列化二叉树
 *
 * 题目:请实现两个函数，分别用来序列化和反序列化二叉树
 *      二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，
 *          从而使得内存中建立起来的二叉树可以持久保存。序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，
 *          序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
 *      二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 *
 *
 * 思路:1.递归遍历二叉树的节点，空节点使用#代替，节点之间使用逗号隔开，返回字符串
 *      2.设置序号index，将字符串根据逗号分割为数组，根据index的值来设置树节点的val，如果节点的值为#，则返回空的树节点。
 *
 *
 *
 *
 *
 */


class Java_61 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    int index = -1;
    /**
     * 分别遍历左节点和右节点，空使用#代替，节点之间，隔开
     *
     * @param root
     * @return
     */
    String Serialize(TreeNode root) {
        if (root == null) {
            return "#";
        } else {
            return root.val + "," + Serialize(root.left) + "," + Serialize(root.right);
        }
    }

    /**
     * 使用index来设置树节点的val值，递归遍历左节点和右节点，如果值是#则表示是空节点，直接返回
     *
     * @param str
     * @return
     */
    TreeNode Deserialize(String str) {
        String[] strings = str.split(",");
        index++;
        int len = strings.length;
        if (index > len)
            return null;
        TreeNode treeNode = null;
        if (!strings[index].equals("#")) {
            treeNode = new TreeNode(Integer.parseInt(strings[index]));
            treeNode.left = Deserialize(str);
            treeNode.right = Deserialize(str);
        }
        return treeNode;
    }

    public static void main(String[] args) {
        Java_61 java_49 = new Java_61();
    }


}