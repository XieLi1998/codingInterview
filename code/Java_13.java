
/*
 * [13] 调整数组顺序使奇数位于偶数前面
 *
 * 题目:输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 *      并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 *
 * 思路:1.插入排序，时间复杂度O(n^2)
 *      2.队列，时间复杂度为O(n)
 *
 *
 *
 */


import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

class Java_13 {

    public void reOrderArray(int [] array){
        int len = array.length;

        int k = 0;          //排序后的奇数序号
        for (int i = 0; i < len; i++) {
            if (array[i] % 2 == 1){
                int j = i;
                int temp = array[j];
                while (j > k){
                    array[j] = array[j - 1];
                    j--;
                }
                array[k++] = temp;
            }
        }
    }

    public void reOrderArray_02(int [] array){
        Queue<Integer> queue = new LinkedList<>();

        int len = array.length;

        for (int i = 0; i < len; i++) {
            if (array[i] % 2 == 1){
                queue.add(array[i]);
            }
        }

        for (int i = 0; i < len; i++) {
            if (array[i] % 2 == 0){
                queue.add(array[i]);
            }
        }

        for (int i = 0; i < len; i++) {
            array[i] = queue.poll();
        }
    }

    public static void main(String[] args) {
        Java_13 java_13 = new Java_13();
        int[] c = new int[]{2,3,4,5,6,7};
        java_13.reOrderArray_02(c);
        for (int l : c){
            System.out.print(l+" ");
        }

    }

}