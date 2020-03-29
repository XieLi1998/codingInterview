
/*
 * [44] 翻转单词顺序列
 *
 * 题目:牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 *      同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 *      例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确
 *      的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 *
 *
 * 思路:1.调用库函数
 *
 *
 *
 */


class Java_44 {

    public String ReverseSentence(String str) {
        if (str.trim().equals(""))
            return str;
        String[] chars = str.split(" ");
        StringBuffer res = new StringBuffer();
        for (int i = chars.length - 1; i >= 0; i--) {
            res.append(chars[i]);
            if (i > 0)
                res.append(" ");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Java_44 java_40 = new Java_44();
    }


}