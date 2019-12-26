
/*
 * [24] 二叉树中和为某一值的路径
 *
 * 题目:输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 *      (注意: 在返回值的list中，数组长度大的数组靠前)
 *
 *
 *
 * 思路:1.递归做法,注意要校验返回数组的排序
 *
 *
 *
 *
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Java_24 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target){
        helper(root, target, res, list);

        Collections.sort(res, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if (o2.size() > o1.size()){
                    return 1;
                }else {
                    return -1;
                }
            }
        });

        return res;
    }

    public void helper(TreeNode root, int target, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list){
        if (root == null){
            return;
        }

        list.add(root.val);

        target = target - root.val;

        if (target == 0 && root.left == null && root.right == null){
            res.add(new ArrayList<>(list));
        }else {
            FindPath(root.left,target);
            FindPath(root.right,target);
        }

        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        Java_24 java_13 = new Java_24();
    }
    

}