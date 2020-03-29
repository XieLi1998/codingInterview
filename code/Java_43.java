
/*
 * [43] 左旋转字符串
 *
 * 题目:汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
 *      就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你
 *      把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出
 *      循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 *
 *
 * 思路:1.调用库函数
 *
 *
 *
 */


class Java_43 {

    public String LeftRotateString(String str, int n) {
        if (str == null || str.length() == 0 || n <= 0)
            return str;
        int len = str.length();
        String p = str.substring(0, n);
        String q = str.substring(n, len);
        return q + p;
    }

    public static void main(String[] args) {
        Java_43 java_40 = new Java_43();
    }


}