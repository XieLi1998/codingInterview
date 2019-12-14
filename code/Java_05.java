
/*
 * [05] 用两个栈实现队列
 *
 * 题目:用两个栈来实现一个队列，完成队列的Push和Pop操作。
 *      队列中的元素为int类型。
 *
 *
 * 思路:1.当插入时，直接插入stack1
 *      2.当弹出时，如果stack2不为空，优先弹出stack2中的元素，
 *        如果stack2为空，将stack1中的全部数逐个出栈入栈stack2，再弹出stack2栈顶元素
 *
 *
 *
 */


import java.util.Stack;

class Java_05 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.size() <= 0){
            while (stack1.size() != 0){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

}