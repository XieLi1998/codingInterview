
/*
 * [60] 把二叉树打印成多行
 *
 * 题目:从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 *
 *
 * 思路:1.递归实现
 *
 *
 *
 *
 */


import java.util.ArrayList;

class Java_60 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        depth(pRoot, 1, res);
        return res;
    }

    private void depth(TreeNode root, int depth, ArrayList<ArrayList<Integer>> lists) {
        if (root==null)
            return;
        if (depth>lists.size()){
            lists.add(new ArrayList<Integer>());
        }
        lists.get(depth-1).add(root.val);

        depth(root.left,depth+1,lists);
        depth(root.right,depth+1,lists);
    }

    public static void main(String[] args) {
        Java_60 java_49 = new Java_60();
    }


}