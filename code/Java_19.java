
/*
 * [19] 顺时针打印矩阵
 *
 * 题目:输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵：
 *      1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 *
 * 思路:1.不断地收缩矩阵的边界,定义四个变量代表范围，up、down、left、right
 *
 *
 *
 */


import java.util.ArrayList;

class Java_19 {

    public ArrayList<Integer> printMatrix(int [][] matrix){
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return null;
        }

        ArrayList<Integer> pdd = new ArrayList<>();
        int left = 0;
        int right = matrix[0].length - 1;
        int up = 0;
        int down = matrix.length - 1;

        while (true){
            for (int col = left; col <= right; col++) {
                pdd.add(matrix[up][col]);
            }

            up++;
            if (up > down){
                break;
            }

            for (int row = up; row <= down; row++) {
                pdd.add(matrix[row][right]);
            }

            right--;
            if (left > right){
                break;
            }

            for (int col = right; col >= left; col--) {
                pdd.add(matrix[down][col]);
            }

            down--;
            if (up > down){
                break;
            }

            for (int row = down; row >= up; row--) {
                pdd.add(matrix[row][left]);
            }

            left++;
            if (left > right){
                break;
            }

        }
        return pdd;
    }

    public static void main(String[] args) {
        Java_19 java_13 = new Java_19();
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        ArrayList<Integer> res = java_13.printMatrix(arr);
        for (int s : res){
            System.out.print(s+" ");
        }
    }

}