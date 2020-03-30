
/*
 * [60] 把二叉树打印成多行
 *
 * 题目:从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 *
 *
 * 思路:1.递归实现
 *          真的有点巧妙啊~不知道理解的对不对，比如一颗完全二叉树1|23|4567|89123456，遍历左孩子时，
 *          已经到底，{1}，{2}，{4}，{8}左孩子遇到有右节点时，往里填{1}，{2}，{4}，{8，9}，然后递归回到上一层，
 *          {1}，{2}，{4，5}，{8，9，1，}，------->{1}，{2}，{4，5}，{8，9，1，2}，------->{1}，{2,3}，{4，5,6}，
 *          {8，9，1，2,3,4}，------->{1}，{2,3}，{4，5,6,7}，{8，9，1，2,3,4,5,6},这样就完成了
 *      2.非递归实现
 *
 *
 *
 *
 *
 */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
        if (root == null)
            return;
        if (depth > lists.size()) {
            lists.add(new ArrayList<Integer>());
        }
        lists.get(depth - 1).add(root.val);

        depth(root.left, depth + 1, lists);
        depth(root.right, depth + 1, lists);
    }

    /*************************************************************************************************************/


    ArrayList<ArrayList<Integer>> Print_02(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        if (pRoot==null)
            return res;

        Queue<TreeNode> queue=new LinkedList<>();

        queue.offer(pRoot);
        while (!queue.isEmpty()){
            ArrayList<Integer> list=new ArrayList<>();
            int size=queue.size();
            while (size>0){
                TreeNode cur=queue.poll();
                list.add(cur.val);
                if (cur.left!=null){
                    queue.offer(cur.left);
                }
                if (cur.right!=null){
                    queue.offer(cur.right);
                }
                size--;
            }
            res.add(list);
        }
        return res;

    }

    public static void main(String[] args) {
        Java_60 java_49 = new Java_60();
    }


}