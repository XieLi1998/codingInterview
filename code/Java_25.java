
/*
 * [25] 复杂链表的复制
 *
 * 题目:输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 *      返回结果为复制后复杂链表的head。
 *     （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 *
 *
 * 思路:1.第一次遍历，复制新的节点放到原链表中原来节点后面
 *      2.第二次遍历，给新节点附上原结点上的任意指针
 *      3.第三次遍历，分离链表
 *
 *
 *
 *
 */



class Java_25 {

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead){
        if (pHead == null){
            return null;
        }

        //第一次遍历，复制新的节点放到原链表中原来节点后面
        RandomListNode currentNode = pHead;
        while (currentNode != null){
            RandomListNode cloneNode = new RandomListNode(currentNode.label);
            RandomListNode nextNode = currentNode.next;
            currentNode.next = cloneNode;
            cloneNode.next = nextNode;
            currentNode = nextNode;
        }

        //第二次遍历，给新节点附上原结点上的任意指针
        currentNode = pHead;
        while (currentNode != null){
            RandomListNode cloneNode = currentNode.next;
            //此处需注意，新节点上的任意指针指向的也必须是新节点，所以是 currentNode.random 的下一个节点，即新节点
            cloneNode.random = currentNode.random == null ? null : currentNode.random.next;
            currentNode = cloneNode.next;
        }

        //第三次遍历，分离链表
        currentNode = pHead;
        RandomListNode pCloneNode = pHead.next;
        while (currentNode != null){
            RandomListNode cloneNode = currentNode.next;
            currentNode.next = cloneNode.next;
            cloneNode.next = cloneNode.next == null ? null : cloneNode.next.next;
            currentNode = currentNode.next;
        }

        return pCloneNode;
    }

    public static void main(String[] args) {
        Java_25 java_13 = new Java_25();
    }
    

}