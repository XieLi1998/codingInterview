
/*
 * [36] 两个链表的第一个公共结点
 *
 * 题目:输入两个链表，找出它们的第一个公共结点。
 *
 *
 * 思路:遍历两遍这两个链表，如果有重复的节点，那么一定能够使遍历的指针相等。
 *
 *
 *
 *
 */


class Java_36 {


    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null){
            return null;
        }
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;

        while (p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
            if (p1 != p2){
                if (p1 == null){
                    p1 = pHead2;
                } else if (p2 == null){
                    p2 = pHead1;
                }
            }
        }

        return p1;
    }

    public static void main(String[] args) {
        Java_36 java_13 = new Java_36();
    }
    

}