
/*
 * [49] 把字符串转换成整数
 *
 * 题目:将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 *
 *
 * 思路:1.捕捉异常
 *      2.注意溢出
 *
 *
 *
 *
 */


class Java_49 {

    public int StrToInt(String str) {
        Integer res = 0;
        try {
            res = new Integer(str);
        } catch (Exception e) {

        } finally {
            return res;
        }
    }

    public int StrToInt_02(String str) {

        if (str == null || "".equals(str.trim()))
            return 0;
        char[] chars = str.trim().toCharArray();
        int i = 0;
        int flag = 1;
        int res = 0;
        if (chars[i] == '-')
            flag = -1;
        if (chars[i] == '+' || chars[i] == '-')
            i++;
        while (i < chars.length) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                int cur = chars[i] - '0';
                if (flag == 1 && (res > Integer.MAX_VALUE/10 || res == Integer.MAX_VALUE/10 && cur > 7))
                    return 0;
                if (flag == -1 && (res > Integer.MAX_VALUE/10 || res == Integer.MAX_VALUE/10 && cur > 8))
                    return 0;
                res = res * 10 + cur;
                i++;
            } else {
                return 0;
            }
        }
        return flag * res;
    }

    public static void main(String[] args) {
        Java_49 java_49 = new Java_49();
        System.out.println(java_49.StrToInt("+2147483647"));
        System.out.println(java_49.StrToInt("la33"));
    }


}