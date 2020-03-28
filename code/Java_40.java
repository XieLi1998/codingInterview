
/*
 * [40] 数组中只出现一次的数字
 *
 * 题目:一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 *
 *
 * 思路:1.HashMap
 *      2.Arrays.sort + 栈
 *
 *
 *
 */


import java.util.HashMap;

class Java_40 {

    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i]))
                map.put(array[i], 2);
            else
                map.put(array[i], 1);
        }
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i]) == 1) {
                if (count == 0) {
                    num1[0] = array[i];
                    count++;
                } else {
                    num2[0] = array[i];
                }
            }
        }
    }

    public void FindNumsAppearOnce_02(int[] array, int num1[], int num2[]) {

    }

    public static void main(String[] args) {
        Java_40 java_40 = new Java_40();
    }


}