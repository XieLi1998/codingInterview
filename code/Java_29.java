
/*
 * [29] 最小的K个数
 *
 * 题目:输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 *
 *
 *
 * 思路:1.最大堆
 *
 *
 *
 *
 */


import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Java_29 {

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        int len = input.length;
        if (k > len || k <= 0) {
            return res;
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for (int i = 0; i < len; i++) {
            if (i < k) {
                priorityQueue.offer(input[i]);
            } else {
                if (priorityQueue.peek() > input[i]) {
                    priorityQueue.poll();
                    priorityQueue.offer(input[i]);
                }
            }
        }

        for (int ans : priorityQueue) {
            res.add(ans);
        }

        return res;
    }

    public static void main(String[] args) {
        Java_29 java_29 = new Java_29();

        int[] input = new int[]{4, 5, 1, 6, 2, 7,56,64,11,15,9, 3, 8};
        ArrayList<Integer> res = new ArrayList<>();
        res = java_29.GetLeastNumbers_Solution(input, 6);
        for (int i : res) {
            System.out.print(i+" ");
        }
        System.out.println();
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i)+" ");
        }
    }


}