
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
 *      2.如果有符合条件的数字，则它出现的次数比其他所有数字出现的次数和还要多。
 *        在遍历数组时保存两个值：一是数组中一个数字，一是次数。遍历下一个数字时，若它与之前保存的数字相同，
 *        则次数加1，否则次数减1；若次数为0，则保存下一个数字，并将次数置为1。遍历结束后，所保存的数字即为所求。
 *        然后再判断它是否符合条件即可。
 *
 *
 *
 *
 */


import java.util.Arrays;

class Java_28 {

    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        Arrays.sort(array);
        int target = array[array.length / 2];
        int count = 0;
        for (int k : array) {
            if (k == target) {
                count++;
            }
        }
        if (count > array.length / 2) {
            return target;
        } else {
            return 0;
        }
    }

    public int MoreThanHalfNum_Solution_02(int[] array) {
        if (array == null || array.length == 0)
            return 0;

        int res = array[0];
        int count = 1;

        for (int i = 1; i < array.length; i++) {
            if (count == 0) {
                res = array[i];
                count = 1;
            } else if (array[i] == res) {
                count++;
            } else {
                count--;
            }
        }

        count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == res)
                count++;
        }

        if (count > (array.length / 2))
            return res;
        else
            return 0;
    }

    public static void main(String[] args) {
        Java_28 java_13 = new Java_28();

    }


}