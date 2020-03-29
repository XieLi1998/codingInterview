
/*
 * [52] 正则表达式匹配
 *
 * 题目:请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 *      而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。
 *      例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 *
 *
 * 思路:1.字符串匹配,分两种情况分析
 *
 *
 *
 *
 */


class Java_52 {

    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        return matchCore(str, 0, pattern, 0);
    }

    public boolean matchCore(char[] str, int i, char[] pattern, int j) {
        if (j == pattern.length)
            return i == str.length;

        //下一个是*
        if (j < pattern.length - 1 && pattern[j + 1] == '*') {
            //当前匹配
            if (str.length != i &&
                    (str[i] == pattern[j] || pattern[j] == '.'))
                return matchCore(str, i, pattern, j + 2)
                        || matchCore(str, i + 1, pattern, j);

            //当前不匹配
            else
                return matchCore(str, i, pattern, j + 2);
        }

        //下一个不是*
        if (str.length != i &&
                (str[i] == pattern[j] || pattern[j] == '.'))
            return matchCore(str, i + 1, pattern, j + 1);

        return false;
    }

    public static void main(String[] args) {
        Java_52 java_40 = new Java_52();
    }


}