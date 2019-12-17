
/*
 * [10] 矩形覆盖
 *
 * 题目:我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的
 *      小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 *
 * 思路:1.熟悉的配方，熟悉的味道，还是斐波那契数列啊,详情参见Java_08
 *
 *
 *
 */


import java.util.Arrays;

class Java_10 {

    public int RectCover(int target){
        if (target <= 2){
            return target;
        }

        return RectCover(target - 1) + RectCover(target - 2);
    }

    public static void main(String[] args) {
        Java_10 test = new Java_10();
    }

}