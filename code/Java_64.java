
/*
 * [64] 滑动窗口的最大值
 *
 * 题目:给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组
 *      {2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 *      针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}，
 *      {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}
 *
 *
 * 思路:
 *
 *
 *
 *
 */


import java.util.ArrayList;
import java.util.LinkedList;

class Java_64 {

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (num == null || num.length == 0 || size <= 0 || num.length < size)
            return res;
        LinkedList<Integer> qmax = new LinkedList<>();
        int index = 0;
        //记录最大值的下标
        for (int i = 0; i < num.length; i++) {
            while (!qmax.isEmpty() && num[qmax.peekLast()] < num[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            //判断队首元素是否过期
            if (qmax.peekFirst() == i - size) {
                qmax.pollFirst();
            }
            //向result列表中加入元素
            if (i >= size - 1) {
                res.add(num[qmax.peekFirst()]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Java_64 java_49 = new Java_64();
    }


}