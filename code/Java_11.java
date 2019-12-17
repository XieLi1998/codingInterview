
/*
 * [11] 二进制中1的个数
 *
 * 题目:输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 *
 * 思路:1.用1和n的每位进行位与，来判断1的个数
 *      2.找规律，如果一个整数不为0，那么这个整数至少有一位是1。如果我们把这个整数减1，
 *        那么原来处在整数最右边的1就会变为0，原来在1后面的所有的0都会变成1(如果最右边的1后面还有0的话)。
 *        其余所有位将不会受到影响
 *        举例子，1100 & 1011 = 1000 ，1000 & 0999 = 0000，遍历两次，所以1100中 1 的个数为 2
 *
 *
 *
 */


class Java_11 {

    public int NumberOf1(int n){
        int count = 0;
        while (n != 0){
            count += (n & 1);
            //有可能会有负数，所以要用>>>
            n >>>= 1;
        }
        return count;
    }

    public int NumberOf1_02(int n){
        int count = 0;
        while (n != 0){
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Java_11 test = new Java_11();
        System.out.println(test.NumberOf1(100));
        System.out.println(test.NumberOf1_02(100));
    }

}