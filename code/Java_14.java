
/*
 * [14] 链表中倒数第k个结点
 *
 * 题目:输入一个链表，输出该链表中倒数第k个结点。
 *
 *
 * 思路:1.快慢指针
 *      2.栈
 *
 *
 *
 */


import java.util.Stack;

class Java_14 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head,int k){
        if (head == null || k <= 0){
            return null;
        }

        ListNode fast = head, slow = head;

        for (int i = 0; i < k; i++) {
            if (fast == null){
                return null;
            }
            fast = fast.next;
        }

        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    public ListNode FindKthToTail_02(ListNode head,int k){
        if (head == null || k <= 0){
            return null;
        }

        Stack<ListNode> stack = new Stack<>();
        int count = 0;

        while (head != null){
            stack.push(head);
            head = head.next;
            count++;
        }

        if (count < k){
            return null;
        }

        ListNode res = null;
        for (int i = 0; i < k; i++) {
            res = stack.pop();
        }

        return res;
    }

    public static void main(String[] args) {
        Java_14 java_13 = new Java_14();
        int[] c = new int[]{2,3,4,5,6,7};

    }

}