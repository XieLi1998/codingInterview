
/*
 * [07] 斐波那契数列
 *
 * 题目:大家都知道斐波那契数列，现在要求输入一个整数n，
 *      请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 *      n<=39
 *
 *
 * 思路:1.递归,斐波那契数列的标准公式为：F(1)=1，F(2)=1,
 *        F(n)=F(n-1)+F(n-2)（n>=3，n∈N*）,时间复杂度为O(2^n)
 *      2.优化递归，用数组存储结果，时间复杂度为O(n)
 *      3.优化存储，我们可以发现每次就用到了最近的两个数，
 *        所以我们可以只存储最近的两个数，时间复杂度为O(n)
 *      4.优化存储-加强版，其实也没啥加强的，就是看起来不明觉厉，
 *        原理和第三版一样，时间复杂度为O(n)
 *
 *
 *
 */


import java.util.Arrays;
import java.util.PriorityQueue;

class Java_07 {

    public int Fibonacci(int n) {
        if (n <= 1){
            return n;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    public int Fibonacci_02(int n) {
        int[] ans = new int[40];
        ans[0] = 0;
        ans[1] = 1;
        for (int i = 2; i <= n; i++) {
            ans[i] = ans[i - 1] + ans[i - 2];
        }
        return ans[n];
    }

    public int Fibonacci_03(int n) {
        if (n <= 1){
            return n;
        }

        int sum = 0;
        int one = 1;    //one代表第 n-1 项
        int two = 0;    //two代表第 n-2 项

        for (int i = 2; i <= n; i++) {
            sum = one + two;
            two = one;
            one = sum;
        }

        return sum;
    }

    public int Fibonacci_04(int n) {
        if (n <= 1){
            return n;
        }

        int sum = 1;
        int one = 0;

        for (int i = 2; i <= n; i++) {
            sum = sum + one;
            one = sum - one;
        }

        return sum;
    }

    public static void main(String[] args) {
        Java_07 test = new Java_07();
        System.out.println(test.Fibonacci_04(5));
    }

}