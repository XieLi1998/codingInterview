
/*
 * [35] 数组中的逆序对
 *
 * 题目:在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 *      输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 *
 *
 * 思路:递归 + 归并排序
 *
 *
 *
 *
 */


class Java_35 {

    public int InversePairs(int[] array) {
        if (array == null || array.length == 1 || array.length == 0) {
            return 0;
        }
        return CountCore(array, 0, array.length - 1) % 1000000007;
    }

    public int CountCore(int[] array, int low, int high) {
        if (low == high) {
            return 0;
        }
        int mid = (low + high) / 2;
        int leftCount = CountCore(array, low, mid) % 1000000007;
        int rightCount = CountCore(array, mid + 1, high) % 1000000007;
        return leftCount + rightCount + Merge(array, low, high, mid);
    }

    public int Merge(int[] array, int low, int high, int mid) {
        int[] temp = new int[high - low + 1];
        int p1 = low, p2 = mid + 1;
        int count = 0;
        int index = 0;

        while (p1 <= mid && p2 <= high) {
            if (array[p1] > array[p2]) {
                count += mid - p1 + 1;
                if (count >= 1000000007) {
                    count %= 1000000007;
                }
                temp[index++] = array[p2++];
            } else {
                temp[index++] = array[p1++];
            }
        }

        while (p1 <= mid) {
            temp[index++] = array[p1++];
        }

        while (p2 <= high) {
            temp[index++] = array[p2++];
        }

        for (int i = 0; i < temp.length; i++) {
            array[low++] = temp[i];
        }

        return count % 1000000007;
    }

    public static void main(String[] args) {
        Java_35 java_13 = new Java_35();
        int[] list = new int[]{364, 637, 341, 406, 747, 995, 234, 971, 571, 219, 993, 407, 416, 366, 315, 301, 601, 650, 418, 355, 460, 505, 360, 965, 516, 648, 727, 667, 465, 849, 455, 181, 486, 149, 588, 233, 144, 174, 557, 67, 746, 550, 474, 162, 268, 142, 463, 221, 882, 576, 604, 739, 288, 569, 256, 936, 275, 401, 497, 82, 935, 983, 583, 523, 697, 478, 147, 795, 380, 973, 958, 115, 773, 870, 259, 655, 446, 863, 735, 784, 3, 671, 433, 630, 425, 930, 64, 266, 235, 187, 284, 665, 874, 80, 45, 848, 38, 811, 267, 575};
        System.out.println(java_13.InversePairs(list));
    }


}