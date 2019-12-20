
/*
 * [17] 树的子结构
 *
 * 题目:输入两棵二叉树A，B，判断B是不是A的子结构。
 *      ps：我们约定空树不是任意一个树的子结构
 *
 *
 * 思路:1.递归
 *
 *
 *
 */




class Java_17 {


     public class TreeNode {
         int val = 0;
         TreeNode left = null;
         TreeNode right = null;

         public TreeNode(int val) {
             this.val = val;
         }

     }

    public boolean HasSubtree(TreeNode root1,TreeNode root2){
        boolean res = false;

        if (root1 != null && root2 != null){
            if (root1.val == root2.val){
                res = HasSubtreeHelper(root1, root2);
            }

            //如果找不到，那么就再去root的左儿子当作起点，去判断时候包含Tree2
            if (!res){
                res = HasSubtree(root1.left,root2);
            }

            //如果找不到，那么就再去root的右儿子当作起点，去判断时候包含Tree2
            if (!res){
                res = HasSubtree(root1.right,root2);
            }
        }

        return res;
    }

    public boolean HasSubtreeHelper(TreeNode root1,TreeNode root2){
        //如果Tree2已经遍历完了都能对应的上，返回true
         if (root2 == null){
            return true;
        }

        //如果Tree2还没有遍历完，Tree1却遍历完了。返回false
        if (root1 == null){
            return false;
        }

        if (root1.val == root2.val){
            return HasSubtreeHelper(root1.left,root2.left)
                    && HasSubtreeHelper(root1.right, root2.right);
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        Java_17 java_13 = new Java_17();
        int[] c = new int[]{2,3,4,5,6,7};
    }

}