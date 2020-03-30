
/*
 * [59] 按之字形顺序打印二叉树
 *
 * 题目:请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
 *      第三行按照从左到右的顺序打印，其他行以此类推
 *
 *
 * 解题思路：其实就是二叉树的层级遍历，不过是在遍历的时候，需要将偶数层的节点逆序。
 *          关键点：每次只处理上次在queue中剩余的节点，这是上一层的所有节点。
 *          处理完后刚好将下一层的所有节点（包含null）又全部放了进去。
 *
 *
 *
 *
 */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Java_59 {

    public class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }


    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        boolean reverse = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                if (!reverse) {
                    list.add(node.val);
                } else {
                    list.add(0, node.val);
                }
                queue.offer(node.left);
                queue.offer(node.right);
            }
            if (list.size() > 0) {
                res.add(list);
            }
            reverse = !reverse;
        }
        return res;
    }

    public static void main(String[] args) {
        Java_59 java_57 = new Java_59();
    }


}