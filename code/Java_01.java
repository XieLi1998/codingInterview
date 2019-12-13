/*
 * [739] 每日温度
 *
 * 题目:在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 *      每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和
 *      一个整数，判断数组中是否含有该整数
 *
 * 思路:1.从左下开始找，左下角的值，是该行最小的值，同时是该列最大的值
 *        同理可得从右上开始找,时间复杂度O(行高+列宽)
 *      2.暴力查找，从左上角开始，从小到大，遍历查找，时间复杂度O(n*n)
 *
 */

class Solution {
    public boolean Find(int target, int[][] array) {
        int rows = array.length;
        int cols = array[0].length;
        int i = rows - 1;
        int j = 0;

        while (i >= 0 && j < cols){
            if (target < array[i][j])
                i--;
            else if (target > array[i][j])
                j++;
            else
                return true;
        }
        return false;
    }
}

class Solution_02 {
    public boolean Find(int target, int[][] array) {
        int rows = array.length;
        int cols = array[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (array[i][j] == target)
                    return true;
            }
        }
        return false;
    }
}