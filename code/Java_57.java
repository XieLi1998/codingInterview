
/*
 * [57] 二叉树的下一个结点
 *
 * 题目:给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 *      注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针
 *
 *
 * 思路:1.还原二叉树
 *      既然给了二叉树的某个结点，且二叉树存储着指向父结点的指针（next），那我们可以先找到根节点，
 *      再对树进行中序遍历，最后根据中序遍历结果找到给定结点的下一结点
 *      时间复杂度：O(n)，空间复杂度：O(n)
 *      2.直接找下一结点
 *          1)有右子树，下一结点是右子树中的最左结点，例如 B，下一结点是 H
 *          2)无右子树，且结点是该结点父结点的左子树，则下一结点是该结点的父结点，例如 H，下一结点是 E
 *          3)无右子树，且结点是该结点父结点的右子树，则我们一直沿着父结点追朔，直到找到某个结点是其父结点的左子树，
 *            如果存在这样的结点，那么这个结点的父结点就是我们要找的下一结点。例如 I，下一结点是 A；例如 G，并没有
 *            符合情况的结点，所以 G 没有下一结点
 *        时间复杂度：O(n)，空间复杂度：O(1)
 *
 *
 *
 *
 */


import java.util.ArrayList;

class Java_57 {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    ArrayList<TreeLinkNode> list = new ArrayList<>();

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        TreeLinkNode par = pNode;
        while (par.next != null)
            par = par.next;
        InOrder(par);
        for (int i = 0; i < list.size(); i++) {
            if (pNode == list.get(i)) {
                return i == list.size() - 1 ? null : list.get(i + 1);
            }
        }
        return null;
    }

    private void InOrder(TreeLinkNode pNode) {
        if (pNode != null) {
            InOrder(pNode.left);
            list.add(pNode);
            InOrder(pNode.right);
        }
    }

    /***************************************************************************************************************/


    public TreeLinkNode GetNext_02(TreeLinkNode pNode) {
            if (pNode.right!=null){
                TreeLinkNode pRight=pNode.right;
                while (pRight.left!=null){
                    pRight=pRight.left;
                }
                return pRight;
            }

            if (pNode.next !=null && pNode.next.left==pNode){
                return pNode.next;
            }

            if (pNode.next!=null){
                TreeLinkNode pNext=pNode.next;
                while (pNext.next!=null && pNext.next.right==pNext){
                    pNext=pNext.next;
                }
                return pNext.next;
            }

            return null;
    }

    public static void main(String[] args) {
        Java_57 java_57 = new Java_57();
    }


}