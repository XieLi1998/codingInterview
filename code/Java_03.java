
/*
 * [03] 从尾到头打印链表
 *
 * 题目:输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 *
 * 思路:1.非递归，时间复杂度O(n)
 *      2.递归，时间复杂度O(n)
 *
 */

import java.util.ArrayList;

class Java_03 {


    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public class Solution {
        public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
            ArrayList<Integer> res = new ArrayList<>();
            ListNode temp = listNode;

            while (temp != null){
                //注意是从尾到头，逆序打印
                res.add(0,temp.val);
                temp = temp.next;
            }

            return res;
        }
    }

    public class Solution_02 {

        //递归的是时候要把动态数组res放在外面，否则的话每次递归，res都会被重置成0，最后只有一个值
        ArrayList<Integer> res = new ArrayList<>();

        public ArrayList<Integer> printListFromTailToHead(ListNode listNode){

            if (listNode != null) {
                printListFromTailToHead(listNode.next);
                res.add(listNode.val);
            }

            return res;
        }
    }
}