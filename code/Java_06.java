
/*
 * [06] 旋转数组的最小数字
 *
 * 题目:把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *      输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 *      例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 *      NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 *
 * 思路:1.暴力查找法，因为两端数组都是非降序，当不符合这个规律时，
 *        就找到了最小数字，时间复杂度为O(n)
 *      2.利用Arrays工具类里面的排序函数，时间复杂度为O(nlogn)
 *      3.利用优先队列，优先队列默认为最小堆，弹出的第一个数就是数组里最小的数
 *        时间复杂度为O(n)
 *      4.二分查找变种，那么用中间值和高低位进行比较，看处于递增还是递减序列，
 *        进行操作缩小范围，处于递增：low上移，处于递减：high下移，时间复杂度为O(logn)
 *
 *
 */


import java.util.Arrays;
import java.util.PriorityQueue;

class Java_06 {

    public int minNumberInRotateArray(int[] array) {
        int len = array.length;
        if (len == 0) {
            return 0;
        }

        for (int i = 0; i < len; i++) {
            if (array[i] > array[i + 1]) {
                return array[i + 1];
            }
        }

        //此处可以返回一个随意值，因为按题意是不会运行到这里的
        return array[0];
    }

    public int minNumberInRotateArray_02(int[] array) {
        int len = array.length;
        if (len == 0) {
            return 0;
        }
        Arrays.sort(array);
        return array[0];
    }

    public int minNumberInRotateArray_03(int[] array) {
        int len = array.length;
        if (len == 0) {
            return 0;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < len; i++) {
            queue.add(array[i]);
        }
        return queue.poll();
    }

    public int minNumberInRotateArray_04(int[] array) {
        if (array.length == 0) {
            return 0;
        }

        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (array[low] < array[high]) {
                return array[low];
            }
            if (array[mid] > array[mid + 1]) {
                return array[mid + 1];
            }
            if (array[mid - 1] > array[mid]) {
                return array[mid];
            }

            //每次low,high只能变一个
            if (array[mid] > array[low]) {
                low = mid + 1;
            } else if (array[mid] < array[high]) {
                high = mid - 1;
            }

        }

        return 0;
    }

    public int minNumberInRotateArray_04_Pro(int[] array) {
        if (array == null || array.length == 0)
            return 0;

        int low = 0;
        int high = array.length - 1;
        while (low < high) {
            if (array[low] < array[high])
                return array[low];
            int mid = low + (high - low) >> 1;
            if (array[mid] > array[low]) {
                low = mid + 1;
            } else if (array[high] > array[mid]) {
                high = mid;
            } else {
                low++;
            }
        }
        return array[low];
    }

}