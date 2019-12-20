
/*
 * [16] 反转链表
 *
 * 题目:输入一个链表，反转链表后，输出新链表的表头。
 *
 *
 * 思路:1.非递归版本
 *      2.递归版本
 *
 *
 *
 */




class Java_16 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode Merge(ListNode list1, ListNode list2){
        ListNode head = new ListNode(0);
        ListNode root = head;

        while (list1 != null && list2 != null){
            if (list1.val < list2.val){
                head.next = list1;
                head = head.next;
                list1 = list1.next;
            }else {
                head.next = list2;
                head = head.next;
                list2 = list2.next;
            }
        }

        //如果还存在未遍历完的数组
        if (list1 != null){
            head.next = list1;
        }

        if (list2 != null){
            head.next = list2;
        }

        return root.next;
    }

    public ListNode Merge_02(ListNode list1, ListNode list2) {
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        if (list1.val < list2.val){
            list1.next = Merge_02(list1.next, list2);
            return list1;
        }else {
            list2.next = Merge_02(list1, list2.next);
            return list2;
        }
    }


    public static void main(String[] args) {
        Java_16 java_13 = new Java_16();
        int[] c = new int[]{2,3,4,5,6,7};
    }

}