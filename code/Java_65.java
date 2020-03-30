
/*
 * [65] 矩阵中的路径
 *
 * 题目:请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 *      路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 *      如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子
 *
 *
 * 思路:
 *
 *
 *
 *
 */


class Java_65 {

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        boolean[] flag = new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (judge(matrix, i, j, rows, cols, flag, str, 0))
                    return true;
            }
        }
        return false;
    }

    //judge(初始矩阵，索引行坐标i，索引纵坐标j，矩阵行数，矩阵列数，待判断的字符串，k为字符串的下标)
    private boolean judge(char[] matrix, int i, int j, int rows, int cols, boolean[] flag, char[] str, int k) {
        int index = i * cols + j;
        if (i < 0 || j < 0 || j >= cols || i >= rows ||
                matrix[index] != str[k] || flag[index] == true)
            return false;

        if (k == str.length - 1)
            return true;

        //要走的第一个位置置为true，表示已经走过了
        flag[index] = true;

        //回溯，递归寻找，每次找到了就给k加一，找不到，还原
        if (judge(matrix, i - 1, j, rows, cols, flag, str, k + 1) ||
                judge(matrix, i + 1, j, rows, cols, flag, str, k + 1) ||
                judge(matrix, i, j - 1, rows, cols, flag, str, k + 1) ||
                judge(matrix, i, j + 1, rows, cols, flag, str, k + 1))
            return true;

        //走到这，说明这一条路不通，还原，再试其他的路径
        flag[index] = false;
        return false;
    }

    public static void main(String[] args) {
        Java_65 java_49 = new Java_65();
    }


}