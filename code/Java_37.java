
/*
 * [37] 数字在排序数组中出现的次数
 *
 * 题目:统计一个数字在排序数组中出现的次数。
 *
 *
 * 思路:1.用java内部的工具类中的二分搜索
 *      2.因为data中都是整数，所以可以稍微变一下，不是搜索k的两个位置，而是搜索k-0.5和k+0.5
 *      3.自己手写二分查找,这个做法只写了升序数组的解法，因为考虑两种情况的话代码过于繁琐
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
        if (array == null || array.length ==0){
            return 0;
        }
        if (array[0] > array[array.length - 1]) {
            return binarySearch(array, k - 0.5) - binarySearch(array, k + 0.5);
        } else {
            return binarySearch(array, k + 0.5) - binarySearch(array, k - 0.5);
        }
    }

    private int binarySearch(int[] array, double k){
        int low = 0, high = array.length - 1;

        if (array[low] > array[high]){
            while (low <= high) {
                int mid = (high - low) / 2 + low;

                if (array[mid] < k) {
                    high = mid - 1;
                } else if (array[mid] > k) {
                    low = mid + 1;
                }
            }
        }else {
            while (low <= high) {
                int mid = (high - low) / 2 + low;

                if (array[mid] < k) {
                    low = mid + 1;
                } else if (array[mid] > k) {
                    high = mid - 1;
                }
            }
        }

        return low;
    }

    public int GetNumberOfK_03(int [] array , int k) {
        if (array == null || array.length == 0){
            return 0;
        }

        int firstK = getFirstK(array, k, 0, array.length - 1);
        int lastK = getLastK(array, k, 0, array.length - 1);
        if (firstK != -1 && lastK != -1){
            return lastK - firstK + 1;
        }

        return 0;
    }

    private int getFirstK(int [] array , int k, int start, int end){
        if (start > end){
            return -1;
        }

        int mid = (end - start) / 2 + start;
        //递归写法
        if (array[mid] < k){
            return getFirstK(array, k, mid + 1, end);
        } else if (array[mid] > k){
            return getFirstK(array, k, start, mid - 1);
        } else if (mid - 1 >= 0 && array[mid - 1] == k){
            return getFirstK(array, k, start, mid - 1);
        } else {
            return mid;
        }
    }

    private int getLastK(int [] array , int k, int start, int end){
        int mid = (end - start) / 2 + start;

        //循环写法
        while (start <= end){
            if (array[mid] < k){
                start = mid + 1;
            } else if (array[mid] > k){
                end = mid - 1;
            } else if (mid + 1 < array.length && array[mid + 1] == k){
                start = mid + 1;
            } else {
                return mid;
            }

            mid = (end - start) / 2 + start;
        }

        return -1;
    }

    public static void main(String[] args) {
        Java_37 java_13 = new Java_37();
        System.out.println(java_13.GetNumberOfK(new int[]{5,4,3,3,3,2,1},3));
        System.out.println(java_13.GetNumberOfK_02(new int[]{1,2,3,3,3,4,5},3));
        System.out.println(java_13.GetNumberOfK_03(new int[]{1,2,3,3,3,4,5},3));
        System.out.println("-----------------------------------------------");
        System.out.println(java_13.GetNumberOfK_02(new int[]{5,4,3,3,3,2,1},3));
    }
    

}