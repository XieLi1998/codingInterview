
/*
 * [67] 剪绳子
 *
 * 题目:给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），
 *      每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
 *      例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 *
 * 思路:因为2和3在不切的时候就是最大的值，而2和3的最大值是1和2，是因为如果长度为2或者3时必须至少切一刀。
 *
 *
 *
 *
 */


class Java_67 {

    public int cutRope(int target) {
        if (target == 2)
            return 1;
        if (target == 3)
            return 2;
        int[] dp = new int[target + 1];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        //记录最大值
        int res = 0;
        for (int i = 4; i <= target; i++) {
            for (int j = 1; j <= i / 2; j++) {
                res = Math.max(res, dp[j] * dp[i - j]);
            }
            dp[i] = res;
        }
        return dp[target];
    }


    public static void main(String[] args) {
        Java_67 java_49 = new Java_67();
    }


}