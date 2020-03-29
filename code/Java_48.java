
/*
 * [48] 不用加减乘除做加法
 *
 * 题目:写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 *
 *
 * 思路:1.使用位运算实现加法
 *
 *
 *
 *
 */


class Java_48 {

    public int Add(int num1, int num2) {
        int result = 0;
        int carry = 0;
        do {
            result = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = result;
            num2 = carry;
        } while (carry != 0);
        return result;
    }

    public static void main(String[] args) {
        Java_48 java_40 = new Java_48();
    }


}