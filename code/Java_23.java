
/*
 * [23] 二叉搜索树的后序遍历序列
 *
 * 题目:输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。
 *      假设输入的数组的任意两个数字都互不相同。
 *
 *
 *
 * 思路:1.递归分割法，时间复杂度为O(nlogn)
 *
 *
 *
 *
 */



class Java_23 {

    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0){
            return false;
        }
        return VerifySquenceOfBST_Helper(sequence, 0, sequence.length - 1);
    }

    public boolean VerifySquenceOfBST_Helper(int [] sequence, int start, int root){
        if (start >= root){
            return true;
        }

        int i;

        //寻找左子树，右子树的分界点
        for (i = start; i < root; i++) {
            if (sequence[i] > sequence[root]){
                break;
            }
        }

        //判断右子树中是否有不满足条件的值
        for (int j = i; j < root; j++) {
            if (sequence[j] < sequence[root]){
                return false;
            }
        }

        return VerifySquenceOfBST_Helper(sequence, start, i - 1)
                && VerifySquenceOfBST_Helper(sequence, i, root - 1);
    }

    public static void main(String[] args) {
        Java_23 java_13 = new Java_23();
    }


}