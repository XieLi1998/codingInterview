
/*
 * [08] 跳台阶
 *
 * 题目:一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上
 *      一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 *
 * 思路:1.递归
 *      2.斐波那契数列的变种
 *
 *
 *
 */


class Java_08 {

    public int JumpFloor(int target) {
        if (target <= 2){
            return target;
        }

        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }

    public int JumpFloor_02(int target) {
        if (target <= 2){
            return target;
        }

        int sum = 0;
        int one = 2;
        int two = 1;

        for (int i = 3; i <= target; i++) {
            sum = one + two;
            two = one;
            one = sum;
        }

        return sum;
    }

    public static void main(String[] args) {
        Java_08 test = new Java_08();
        System.out.println(test.JumpFloor(2));
        System.out.println(test.JumpFloor(3));
    }

}