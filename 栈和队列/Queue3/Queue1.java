https://leetcode.cn/problems/design-circular-deque/description/


// 1. 双向链表实现的 双端队列
// 可以从头 入/删 数据
// 可以从尾 入/删 数据
class MyCircularDeque1 {

    static class Node<T> {
        Node<T> prev;
        T val;
        Node<T> next;

        public Node(T val) {
            this.val = val;
        }
    }

    public Node<Integer> head;
    public Node<Integer> tail;
    public int size;
    public int limit;

    public MyCircularDeque1(int k) {
        size = 0;
        limit = k;
    }

    // 头插
    public boolean insertFront(int value) {
        Node<Integer> node = new Node<>(value);
        if (isFull()) {
            return false;
        }

        if (head == null) {
            head = tail = node;
        }else {
            head.prev = node;
            node.next = head;
            head = node;
        }
        size++;
        return true;
    }

    // 尾插数据
    public boolean insertLast(int value) {
        Node<Integer> node = new Node<>(value);
        if (isFull()) {
            return false;
        }
        if (head == null) {
            head = tail = node;
        }else {
           node.prev = tail;
           tail.next = node;
           tail = node;
        }
        size++;
        return true;
    }

    // 头删
    public boolean deleteFront() {
        if(isEmpty()) {
            return false;
        }else {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }else {
                tail = null;
            }
        }
        size--;
        return true;
    }

    // 尾删
    public boolean deleteLast() {
        if(isEmpty()) {
            return false;
        }else {
           Node<Integer> prev = tail.prev;
           if (prev != null) {
               prev.next = null;
               tail = prev;
           }else {
               head = tail = null;
           }
           size--;
           return true;
        }
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }else {
            return head.val;
        }
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }else {
            return tail.val;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return limit == size;
    }
}

