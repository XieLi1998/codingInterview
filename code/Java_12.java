
/*
 * [12] 数值的整数次方
 *
 * 题目:给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *      保证base和exponent不同时为0
 *
 *
 * 思路:1.利用库函数
 *      2.暴力计算，时间复杂度为O(n)
 *      3.快速幂，时间复杂度为O(logn)
 *
 *
 *
 */


class Java_12 {


    public double Power(double base, int exponent){
        return Math.pow(base, exponent);
    }

    public double Power_02(double base, int exponent){
        if (base == 0){
            return 0;
        }
        if (exponent == 0){
            return 1;
        }

        double res = 1;
        int flag = exponent > 0 ? 1 : -1;
        exponent = exponent > 0 ? exponent : -exponent;
        for (int i = 1; i <= exponent; i++) {
            res *= base;
        }

        if (flag < 0){
            res = 1 / res;
        }

        return res;
    }

    public double Power_03(double base, int exponent){
        int n = Math.abs(exponent);
        double ans = 1;

        while (n != 0){
            if ((n & 1) == 1){
                ans = ans * base;
            }
            base *= base;
            n >>= 1;
        }

        return exponent > 0 ? ans : 1/ans;
    }

    public static void main(String[] args) {
        Java_12 test = new Java_12();
        System.out.println(test.Power_02(2,-3));
        System.out.println(test.Power_03(2,-3));
        System.out.println(test.Power(2,-3));
    }

}