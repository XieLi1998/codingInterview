
/*
 * [33] 丑数
 *
 * 题目:把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
 *      习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 *
 * 思路:丑数能够分解成2^x * 3^y * 5^z,所以只需要把得到的丑数不断地乘以2、3、5之后并放入
 *      他们应该放置的位置即可，设置三个计数器p2、p3、p5来记录2、3、5的个数
 *
 *
 *
 *
 */



class Java_33 {

    public int GetUglyNumber_Solution(int index) {
        if (index <= 0){
            return 0;
        }
        int[] res = new int[index];
        res[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < index; i++) {
            res[i] = Math.min(res[p2] * 2, Math.min(res[p3] * 3, res[p5] * 5));
            if (res[i] == res[p2] * 2){
                p2++;
            }
            if (res[i] == res[p3] * 3){
                p3++;
            }
            if (res[i] == res[p5] * 5){
                p5++;
            }
        }
        return res[index - 1];
    }

    public static void main(String[] args) {
        Java_33 java_13 = new Java_33();
        System.out.println(java_13.GetUglyNumber_Solution(3));
    }
    

}