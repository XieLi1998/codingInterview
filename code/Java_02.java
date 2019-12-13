
/*
 * [02] 替换空格
 *
 * 题目:请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，
 *      当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * 思路:1.调用自带函数
 *      2.用新的数组存
 *
 */

class Java_02 {
    public class Solution {
        public String replaceSpace(StringBuffer str){
            return str.toString().replace(" ","%20");
        }
    }

    public class Solution_02 {
        public String replaceSpace(StringBuffer str){

            //StringBuffer是StringBuilder的前身，其效率有些低，但是允许采用多线程的方式执行添加或删除字符的操作

            StringBuilder result = new StringBuilder();
            //StringBuffer result = new StringBuffer();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == ' '){
                    result.append("%20");
                }else {
                    result.append(str.charAt(i));
                }
            }
            return result.toString();
        }
    }
}