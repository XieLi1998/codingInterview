
/*
 * [55] 链表中环的入口结点
 *
 * 题目:给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null
 *
 *
 * 思路:1.快慢指针,数学结论
 *      两个结论：1)设置快慢指针，假如有环，他们最后一定相遇。
 *              2)两个指针分别从链表头和相遇点继续出发，每次走一步，最后一定相遇与环入口。
 *
 *
 *
 *
 *
 */


class Java_55 {


    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode fast = pHead;
        ListNode low = pHead;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            low = low.next;
            if (fast == low) {
                break;
            }
        }
        if (fast == null || fast.next == null)
            return null;
        low = pHead;
        while (fast != low) {
            fast = fast.next;
            low = low.next;
        }
        return low;
    }

    public static void main(String[] args) {
        Java_55 java_49 = new Java_55();
    }


}