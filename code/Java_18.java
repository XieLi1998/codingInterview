
/*
 * [18] 二叉树的镜像
 *
 * 题目:操作给定的二叉树，将其变换为源二叉树的镜像。
 *
 *
 * 思路:1.递归
 *      2.非递归
 *
 *
 *
 */


import java.util.LinkedList;
import java.util.Queue;



class Java_18 {

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }


    public void Mirror(TreeNode root){
         if (root == null){
             return;
         }
         TreeNode temp = root.left;
         root.left = root.right;
         root.right = temp;
         Mirror(root.left);
         Mirror(root.right);
    }

    public void Mirror_02(TreeNode root){
         if (root == null){
             return;
         }

         Queue<TreeNode> queue = new LinkedList<>();
         TreeNode cur, temp;
         queue.offer(root);
         while (!queue.isEmpty()){
             cur = queue.poll();
             temp = cur.left;
             cur.left = cur.right;
             cur.right = temp;
             if (cur.left != null){
                 queue.offer(cur.left);
             }
             if (cur.right != null){
                 queue.offer(cur.right);
             }
         }

    }

    public static void main(String[] args) {
        Java_18 java_13 = new Java_18();
    }

}