
/*
 * [34] 第一个只出现一次的字符
 *
 * 题目:在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
 *      如果没有则返回 -1（需要区分大小写）.
 *
 *
 * 思路:用一个58长度的数组来存储每个字母出现的次数，A-Z对应的ASCII码为65-90，a-z对应的ASCII码值为97-122
 *
 *
 *
 *
 */



class Java_34 {

    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0){
            return -1;
        }
        int[] count = new int[58];
        for (int i = 0; i < str.length(); i++) {
            //此处 122 - 64 = 58，会产生越界
            count[(int)str.charAt(i) - 65]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (count[(int) str.charAt(i) - 65] == 1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Java_34 java_13 = new Java_34();
    }
    

}