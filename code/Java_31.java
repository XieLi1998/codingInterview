
/*
 * [31] 整数中1出现的次数（从1到n整数中1出现的次数）
 *
 * 题目:求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,
 *      可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 *
 *
 * 思路:1.把数字转换成字符数组，在进行遍历查询
 *      2.分别计算个位、十位、百位........上出现 1 的个数,时间复杂度 O(logN)
 *
 *
 *
 *
 */


class Java_31 {

    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        while (n > 0) {
            String s = String.valueOf(n);
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '1') {
                    count++;
                }
            }
            n--;
        }
        return count;
    }

    public int NumberOf1Between1AndN_Solution_02(int n) {
        int count = 0;
        for (int i = 1; i <= n; i *= 10) {
            int div = n / (i * 10);
            int mod = n % (i * 10) / i;

            if (mod > 1) {
                count += (div + 1) * i;
            } else if (mod == 1) {
                count += div * i + 1;
            } else {
                count += div * i;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Java_31 java_13 = new Java_31();
        System.out.println(java_13.NumberOf1Between1AndN_Solution_02(21345));
        System.out.println(java_13.NumberOf1Between1AndN_Solution(21345));
    }


}