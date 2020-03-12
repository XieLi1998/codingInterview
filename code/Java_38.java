
/*
 * [38] 二叉树的深度
 *
 * 题目:输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点
 *      （含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 *
 *
 * 思路:1.递归
 *      2.非递归，层次遍历，队列实现
 *      3.非递归，层次遍历，动态数组实现
 *
 *
 *
 */



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Java_38 {

     public class TreeNode {
         int val = 0;
         TreeNode left = null;
         TreeNode right = null;

         public TreeNode(int val) {
             this.val = val;

         }

     }

    public int TreeDepth(TreeNode root) {
        if (root == null){
            return 0;
        }

        int leftDepth = TreeDepth(root.left);
        int rightDepth = TreeDepth(root.right);
        int result = 1 + (leftDepth > rightDepth ? leftDepth : rightDepth);

        return result;
    }

    public int TreeDepth_02(TreeNode root) {
         if (root == null){
             return 0;
         }

         Queue<TreeNode> queue = new LinkedList<>();
         queue.offer(root);
         int depth = 0, count = 0, nextCount = 1;

         while (queue.size() != 0){
             TreeNode top = queue.poll();
             count++;
             if (top.left != null){
                 queue.offer(top.left);
             }
             if (top.right != null){
                 queue.offer(top.right);
             }
             if (count == nextCount){
                 nextCount = queue.size();
                 count = 0;
                 depth++;
             }
         }

         return depth;
    }

    public int TreeDepth_03(TreeNode root) {
         if (root == null){
             return 0;
         }
         ArrayList<TreeNode> list = new ArrayList<>();
         list.add(root);
         int result = 0;

         while (list.size() > 0){
             result += 1;
             ArrayList<TreeNode> newList = new ArrayList<>();
             for (int i = 0; i < list.size(); i++) {
                 if (list.get(i).left != null){
                     newList.add(list.get(i).left);
                 }
                 if (list.get(i).right != null){
                     newList.add(list.get(i).right);
                 }
             }
             list = newList;
         }

         return result;
    }

    public static void main(String[] args) {
        Java_38 java_13 = new Java_38();
    }
    

}