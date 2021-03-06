
/*
 * [53] 表示数值的字符串
 *
 * 题目:请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 *      例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 *      但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是
 *
 *
 * 思路:1.正则表达式
 *      2.普通解法，按步分析
 *
 *
 *
 *
 */


class Java_53 {


    /*
    以下对正则进行解释:
    [\\+\\-]?            -> 正或负符号出现与否
    \\d*                 -> 整数部分是否出现，如-.34 或 +3.34均符合
    (\\.\\d+)?           -> 如果出现小数点，那么小数点后面必须有数字；
                            否则一起不出现
    ([eE][\\+\\-]?\\d+)? -> 如果存在指数部分，那么e或E肯定出现，+或-可以不出现，
                            紧接着必须跟着整数；或者整个部分都不出现
    */
    public boolean isNumeric(char[] str) {
        String string = String.valueOf(str);
        return string.matches("[\\+\\-]?\\d*(\\.\\d+)?([eE][\\+\\-]?\\d+)?");
    }

    private int index = 0;

    public boolean isNumeric_02(char[] str) {
        if (str.length < 1)
            return false;

        boolean flag = scanInteger(str);

        if (index < str.length && str[index] == '.') {
            index++;

            // 1. 小数可以没有整数部分，例如.123等于0.123；
            // 2. 小数点后面可以没有数字，例如233.等于233.0；
            // 3. 当然小数点前面和后面可以有数字，例如233.666
            flag = scanUnsignedInteger(str) || flag;
        }

        if (index < str.length &&
                (str[index] == 'E' || str[index] == 'e')) {
            index++;

            // 下面一行代码用&&的原因：
            // 1. 当e或E前面没有数字时，整个字符串不能表示数字，例如.e1、e1；
            // 2. 当e或E后面没有整数时，整个字符串不能表示数字，例如12e、12e+5.4
            flag = flag && scanInteger(str);
        }

        return flag && index == str.length;
    }

    private boolean scanInteger(char[] str) {
        if (index < str.length &&
                (str[index] == '+' || str[index] == '-'))
            index++;
        return scanUnsignedInteger(str);
    }

    private boolean scanUnsignedInteger(char[] str) {
        int start = index;
        while (index < str.length && str[index] >= '0' && str[index] <= '9')
            index++;
        //判断是否存在整数
        return start < index;
    }

    public static void main(String[] args) {
        Java_53 java_40 = new Java_53();
    }


}