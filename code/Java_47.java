
/*
 * [47] 求1+2+3+...+n
 *
 * 题目:求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 *
 *
 * 思路:1.这是一个等差数列，sum=(a1+an)n/2=>(1+n)n/2=>(n+n^2)/2；Math.pow(a,b)表示a^b；右移一位相当于除以2
 *      2.利用逻辑与的短路特性实现递归终止
 *
 *
 *
 */


class Java_47 {

    public int Sum_Solution(int n) {
        int sum = (int)Math.pow(n,2)+n;
        return sum>>1;
    }

    public int Sum_Solution_02(int n) {
        int sum=n;
        boolean ans = (n>0) && ((sum+=Sum_Solution(n-1))>0);
        return sum;
    }

    public static void main(String[] args) {
        Java_47 java_40 = new Java_47();
    }


}