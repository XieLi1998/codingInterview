
/*
 * [09] 变态跳台阶
 *
 * 题目:一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 *      求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 *
 * 思路:1.数学，由f(n)=f(n-1)+f(n-2)+……f(1)和f(n-1)=f(n-2)+……f(1)，
 *        两式相减得f(n)=2f(n-1)，时间复杂度为O(2^n)
 *      2.斐波那契数列的变种，斐波那契数列是由前两种状态，而这里就是
 *        由前 n-1 种状态推导出，时间复杂度为O(n^2)
 *
 *
 *
 */


import java.util.Arrays;

class Java_09 {

    public int JumpFloorII(int target) {
        if (target <= 2){
            return target;
        }

        return 2 * JumpFloorII(target - 1);
    }

    public int JumpFloorII_02(int target){
        if (target <= 2){
            return target;
        }

        //dp[0]不会使用，所以要target + 1
        int[] dp = new int[target + 1];
        Arrays.fill(dp,1);
        for (int i = 2; i <= target; i++) {
            for (int j = i - 1; j >= 1; j--) {
                dp[i] += dp[j];
             }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        Java_09 test = new Java_09();
        System.out.println(test.JumpFloorII(5));
        System.out.println(test.JumpFloorII_02(5));
    }

}