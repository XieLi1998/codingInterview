
/*
 * [26] 二叉搜索树与双向链表
 *
 * 题目:输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 *      要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 *
 *
 * 思路:1.递归实现
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

    public void ConvertHelper(TreeNode pRootOfTree){
        if (pRootOfTree == null){
            return;
        }
        ConvertHelper(pRootOfTree.left);
        if (head == null){
            head = pRootOfTree;
            realhead = pRootOfTree;
        }else {
            head.right = pRootOfTree;
            pRootOfTree.left = head;
            head = pRootOfTree;
        }
        ConvertHelper(pRootOfTree.right);
    }

    public static void main(String[] args) {
        Java_26 java_13 = new Java_26();
    }
    

}