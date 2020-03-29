
/*
 * [50] 数组中重复的数字
 *
 * 题目:在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 *      数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 *      请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，
 *      那么对应的输出是第一个重复的数字2
 *
 *
 * 思路:1.将输入数组排序，再判断相邻位置是否存在相同数字，如果存在，对 duplication 赋值返回，否则继续比较
 *          时间复杂度：O(nlogn),空间复杂度：O(1)
 *      2.利用 HashSet 解决，从头到尾扫描数组，每次扫描到一个数，判断当前数是否存在 HashSet 中，如果存在，
 *          则重复，对 duplication 赋值返回，否则将该数加入到 HashSet 中
 *          时间复杂度：O(n),空间复杂度：O(n)
 *
 *
 *
 */


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Java_50 {

    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || length == 0)
            return false;
        Arrays.sort(numbers);
        for (int i = 0; i < length - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }

    public boolean duplicate_02(int numbers[], int length, int[] duplication) {
        Set<Integer> set=new HashSet<>();
        for (int i = 0; i < length; i++) {
            if (set.contains(numbers[i])){
                duplication[0]=numbers[i];
                return true;
            }else {
                set.add(numbers[i]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Java_50 java_40 = new Java_50();
    }


}