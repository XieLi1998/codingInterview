
/*
 * [28] 数组中出现次数超过一半的数字
 *
 * 题目:数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *      例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组
 *      中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 *
 *
 *
 * 思路:1.先排序，如果这个数存在，那么一定在数组中部
 *
 *
 *
 *
 */


import java.util.Arrays;

class Java_28 {

    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0){
            return 0;
        }
        Arrays.sort(array);
        int target = array[array.length/2];
        int count = 0;
        for (int k : array){
            if (k == target){
                count++;
            }
        }
        if (count > array.length/2){
            return target;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Java_28 java_13 = new Java_28();
    }
    

}