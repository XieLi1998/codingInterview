
/*
 * [56] 删除链表中重复的结点
 *
 * 题目:在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，
 *      返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
 *
 * 思路:1.递归解法
 *      2.非递归解法
 *
 *
 *
 *
 *
 */


class Java_56 {


    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplication(ListNode pHead) {
        // 只有0个或1个节点
        if (pHead == null || pHead.next == null)
            return pHead;

        // 当前节点是重复节点
        if (pHead.val == pHead.next.val) {
            ListNode node = pHead.next;
            while (node != null && node.val == pHead.val) {
                // 跳过值与当前节点相同的全部节点，找到第一个与当前节点不同的节点
                node = node.next;
            }
            // 从第一个与当前结点不同的结点继续递归
            return deleteDuplication(node);
        } else {
            // 保留当前节点，从下一个节点继续递归
            pHead.next = deleteDuplication(pHead.next);
        }
        return pHead;
    }

    public ListNode deleteDuplication_02(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return pHead;
        // 新建一个头结点，防止链表中头结点是重复节点被删除。
        ListNode head = new ListNode(-1);
        ListNode trail = head;

        while (pHead != null) {
            ListNode node = pHead.next;
            boolean flag = false;
            while (node != null && node.val == pHead.val) {
                node = node.next;
                flag = true;
            }

            if (!flag) {
                trail.next = pHead;
                trail = trail.next;
            }

            pHead = node;
        }
        trail.next = null;// 1->2->3->3->3
        return head.next;
    }

    public static void main(String[] args) {
        Java_56 java_49 = new Java_56();
    }


}