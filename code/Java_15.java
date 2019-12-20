
/*
 * [15] 反转链表
 *
 * 题目:输入一个链表，反转链表后，输出新链表的表头。
 *
 *
 * 思路:用pre记录当前节点的前一个节点,用next记录当前节点的后一个节点,暴力反转就行了
 *
 *
 *
 */




class Java_15 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode ReverseList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }

        ListNode pre = null;
        ListNode next = null;

        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }

    public static void main(String[] args) {
        Java_15 java_13 = new Java_15();
        int[] c = new int[]{2,3,4,5,6,7};

    }

}