
/*
 * [42] 和为S的两个数字
 *
 * 题目:输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 *      如果有多对数字的和等于S，输出两个数的乘积最小的。
 *
 *
 * 思路:1.滑动窗口，最外层的乘积最小
 *
 *
 *
 */


import java.util.ArrayList;

class Java_42 {

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        int low = 0, high = array.length - 1;
        while (low < high) {
            int temp = array[low] + array[high];
            if (temp == sum) {
                res.add(array[low]);
                res.add(array[high]);
                //此处记得一定要跳出循环
                break;
            } else if (temp > sum) {
                high--;
            } else {
                low++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Java_42 java_40 = new Java_42();
    }


}