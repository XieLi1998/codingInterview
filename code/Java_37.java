
/*
 * [37] 数字在排序数组中出现的次数
 *
 * 题目:统计一个数字在排序数组中出现的次数。
 *
 *
 * 思路:1.用java内部的工具类中的二分搜索
 *      2.因为data中都是整数，所以可以稍微变一下，不是搜索k的两个位置，而是搜索k-0.5和k+0.5
 *        PS:此方法只
 *
 *
 *
 */


import java.util.Arrays;

class Java_37 {

    public int GetNumberOfK(int [] array , int k) {
        int index = Arrays.binarySearch(array, k);

        if (index < 0){
            return 0;
        }

        int count = 0;

        for (int i = index; i < array.length && array[i] == k; i++) {
                count++;
        }

        for (int i = index - 1; i >= 0 && array[i] == k; i--) {
                count++;
        }

        return count;
    }

    public int GetNumberOfK_02(int [] array , int k) {
        int len = array.length;
        if (array[0] > array[len - 1]){
            return binarySearch(array, k - 0.5) - binarySearch(array, k + 0.5);
        } else {
            return binarySearch(array, k + 0.5) - binarySearch(array, k - 0.5);
        }
    }

    private int binarySearch(int[] array, double k){
        int count = 0;
        int low = 0, high = array.length - 1;

        while (low <= high){
            int mid = (high - low) / 2 + low;
            //int mid = (high + low) / 2; 这样写有溢出的风险
            if (array[mid] < k){
                low = mid + 1;
            } else if (array[mid] > k){
                high = mid - 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        Java_37 java_13 = new Java_37();
        System.out.println(java_13.GetNumberOfK(new int[]{1,2,2,3},2));
        System.out.println(java_13.GetNumberOfK_02(new int[]{1,2,2,3},2));
    }
    

}