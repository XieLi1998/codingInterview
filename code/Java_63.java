
/*
 * [63] 数据流中的中位数
 *
 * 题目:如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
 *      那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，
 *      那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，
 *      使用GetMedian()方法获取当前读取数据的中位数
 *
 *
 * 思路:每次插入小顶堆的是当前大顶堆中最大的数
 *      每次插入大顶堆的是当前小顶堆中最小的数
 *      这样保证小顶堆中的数永远大于等于大顶堆中的数
 *      中位数就可以方便地从两者的根结点中获取了
 *
 *
 *
 *
 *
 */


import java.util.Comparator;
import java.util.PriorityQueue;

class Java_63 {

    private PriorityQueue<Integer> minHeap=new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap=new PriorityQueue<>(15, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });

    int count=0;

    public void Insert(Integer num) {
        if (count%2==0){
            maxHeap.offer(num);
            int max=maxHeap.poll();
            minHeap.offer(max);
        }else {
            minHeap.offer(num);
            int min=minHeap.poll();
            maxHeap.offer(min);
        }
        count++;
    }

    public Double GetMedian() {
        if (count%2==0){
            return new Double(minHeap.peek()+maxHeap.peek())/2;
        }else {
            return new Double(minHeap.peek());
        }
    }

    public static void main(String[] args) {
        Java_63 java_49 = new Java_63();
    }


}