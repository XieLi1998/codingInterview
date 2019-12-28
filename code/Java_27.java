
/*
 * [27] 字符串的排列
 *
 * 题目:输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
 *      则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 *
 *
 * 思路:1.递归的全排列算法
 *
 *
 *
 *
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class Java_27 {

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str == null || str.length() == 0){
            return list;
        }
        PermutationHelper(str.toCharArray(),0,list);
        Collections.sort(list);
        return list;
    }

    private void PermutationHelper(char[] chars,int i,ArrayList<String> list){
        if (i == chars.length - 1){
            list.add(String.valueOf(chars));
        } else {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < chars.length; j++) {
                if (j == i || !set.contains(chars[j])){
                    set.add(chars[j]);
                    swap(chars,i,j);
                    PermutationHelper(chars,i + 1, list);
                    swap(chars,i,j);
                }
            }
        }
    }

    private void swap(char[] chars,int i, int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        Java_27 java_13 = new Java_27();
    }
    

}