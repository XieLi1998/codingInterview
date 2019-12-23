
/*
 * [22] 从上往下打印二叉树
 *
 * 题目:从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 *
 *
 * 思路:借助队列
 *
 *
 *
 */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Java_22 {

     public class TreeNode {
         int val = 0;
         TreeNode left = null;
         TreeNode right = null;

         public TreeNode(int val) {
             this.val = val;

         }

     }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root){


        ArrayList<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null){
            return res;
        }

        queue.offer(root);

        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            res.add(temp.val);
            if (temp.left != null){
                queue.offer(temp.left);
            }
            if (temp.right != null){
                queue.offer(temp.right);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Java_22 java_13 = new Java_22();
    }

}