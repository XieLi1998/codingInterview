
/*
 * [55] 字符流中第一个不重复的字符
 *
 * 题目:请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，
 *      当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 *      当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 *      如果当前字符流没有存在出现一次的字符，返回#字符。
 *
 *
 * 思路:1.
 *
 *
 *
 *
 */


import java.util.ArrayList;
import java.util.HashMap;

class Java_55 {

    HashMap<Character,Integer> map=new HashMap<>();
    ArrayList<Character> list=new ArrayList<>();

    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if (map.containsKey(ch)){
            map.put(ch,2);
        }else {
            map.put(ch,1);
        }
        list.add(ch);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        char c='#';
        for(char key:list){
            if (map.get(key)==1){
                c=key;
                break;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        Java_55 java_49 = new Java_55();
    }


}