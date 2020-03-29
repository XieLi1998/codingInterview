
/*
 * [51] 构建乘积数组
 *
 * 题目:给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素
 *      B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 *      （注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
 *
 *
 * 思路:1.B[i]的值可以看作下图的矩阵中每行的乘积。
 *
 *
 *
 *
 */


class Java_51 {

    public int[] multiply(int[] A) {
        int len=A.length;
        int[] B=new int[len];
        if (len!=0){
            B[0]=1;

            //先计算下三角连乘
            for (int i = 1; i < len; i++) {
                B[i]=B[i-1]*A[i-1];
            }
            
            int temp=1;
            //计算上三角
            for (int i = len-2; i >= 0; i++) {
                temp*=A[i+1];
                B[i]*=temp;
            }
        }
        return B;
    }

    public static void main(String[] args) {
        Java_51 java_40 = new Java_51();
    }


}