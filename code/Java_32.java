
/*
 * [32] 把数组排成最小的数
 *
 * 题目:输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
 *      则打印出这三个数字能排成的最小数字为321323。
 *
 *
 * 思路:1.比较两个字符串s1, s2大小的时候，先将它们拼接起来，比较s1+s2,和s2+s1那个大，如果s1+s2大，
 *        那说明s2应该放前面，所以按这个规则，s2就应该排在s1前面
 *
 *
 *
 *
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Java_32 {

    public String PrintMinNumber(int [] numbers) {
        if (numbers == null || numbers.length == 0){
            return "";
        }
        String res = "";
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1 + "" + o2;
                String s2 = o2 + "" + o1;
                return s1.compareTo(s2);
            }
        });


        for (int k : list){
            res = res + "" + k;
        }

        return res;
    }

    public static void main(String[] args) {
        Java_32 java_13 = new Java_32();
        int[] number = new int[]{3,32,321};
        System.out.println(java_13.PrintMinNumber(number));
    }
    

}