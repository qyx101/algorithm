package Queue1;

// 单链表实现的队列
public class Queue1<T> {

    static class Node<T> {
        T val;
        Node<T> next;

        public Node(T val) {
            this.val = val;
        }
    }

    public Node<T> head;
    public Node<T> tail;

    public boolean isEmpty() {
        return 0 == this.size();
    }


    // 尾插
    public void offer(T val) {
        Node<T> node = new Node<>(val);
        if (head == null) {
            this.head = node;
            this.tail = node;
        }else {
            tail.next = node;
            tail = tail.next;
        }
    }

    // 从队列拿，从头拿
    // 头删
    public T poll() {
        T ret = head.val;
        if (head.next == null) {
            head = tail = null;
        }else {
            head = head.next;
        }
        return ret;
    }

    // 返回队列头的元素但是不弹出
    public T peek() {
        return head.val;
    }

    // 返回目前队列里有几个数
    public int size() {
        Node<T> cur = this.head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }
}
