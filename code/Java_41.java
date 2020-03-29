
/*
 * [41] 和为S的连续正数序列
 *
 * 题目:输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 *
 *
 * 思路:1.暴力穷举
 *      2.滑动窗口，递增数组求和公式
 *
 *
 *
 */


import java.util.ArrayList;

class Java_41 {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 1; i < sum; i++) {
            int temp = 0;
            int j = i;
            while (temp < sum) {
                temp += j;
                j++;
            }
            if (temp == sum) {
                ArrayList<Integer> newArray = new ArrayList<>();
                for (int k = i; k < j; k++) {
                    newArray.add(k);
                }
                res.add(newArray);
            }
        }
        return res;
    }

    public ArrayList<ArrayList<Integer>> FindContinuousSequence_02(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int low = 1, high = 2;
        while (high > low) {
            int cur = (low + high) * (high - low + 1) / 2;
            if (cur == sum) {
                ArrayList<Integer> newArray = new ArrayList<>();
                for (int i = low; i <= high; i++) {
                    newArray.add(i);
                }
                res.add(newArray);
                low++;
            } else if (cur < sum) {
                high++;
            } else {
                low++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Java_41 java_40 = new Java_41();
        System.out.println(java_40.FindContinuousSequence(100));
    }


}