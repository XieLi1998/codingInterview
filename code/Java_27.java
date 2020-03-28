
/*
 * [27] 字符串的排列
 *
 * 题目:输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
 *      则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 *
 *
 * 思路:1.递归，全排列
 *      2.非递归，字典序排列
 *      3.回溯法
 *
 *
 *
 *
 */


import java.util.*;

class Java_27 {

    //1.全排列
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return list;
        }
        PermutationHelper(str.toCharArray(), 0, list);
        Collections.sort(list);
        return list;
    }

    private void PermutationHelper(char[] chars, int i, ArrayList<String> list) {
        if (i == chars.length - 1) {
            list.add(String.valueOf(chars));
        } else {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < chars.length; j++) {
                if (!set.contains(chars[j])) {
                    set.add(chars[j]);
                    swap(chars, i, j);
                    PermutationHelper(chars, i + 1, list);
                    swap(chars, i, j);
                }
            }
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    //2.字典序排列
    public ArrayList<String> Permutation_02(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str == null || str.length() == 0)
            return list;
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        list.add(String.valueOf(chars));
        int len = chars.length;
        while (true) {
            int lIndex = len - 1;
            int rIndex;
            while (lIndex >= 1 && chars[lIndex - 1] >= chars[lIndex])
                lIndex--;
            if (lIndex == 0)
                break;
            rIndex = lIndex;
            while (rIndex < len && chars[rIndex] > chars[lIndex - 1])
                rIndex++;
            swap(chars, lIndex - 1, rIndex - 1);
            reverse(chars, lIndex);

            list.add(String.valueOf(chars));
        }

        return list;
    }

    private void reverse(char[] chars, int k) {
        if (chars == null || chars.length <= k)
            return;
        int len = chars.length;
        for (int i = 0; i < (len - k) / 2; i++) {
            int m = k + i;
            int n = len - 1 - i;
            if (m <= n)
                swap(chars, m, n);
        }
    }

    public static void main(String[] args) {
        Java_27 java_13 = new Java_27();
    }


}