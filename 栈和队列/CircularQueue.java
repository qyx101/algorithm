https://leetcode.cn/problems/implement-queue-using-stacks/
class MyCircularQueue {

    public int[] queue;

    public int l, r, size, limit;

    // k 表示队列最大数据个数
    public MyCircularQueue(int k) {
        queue = new int[k];
        limit = k;
        size = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        else {
            queue[r] = value;
            r = r == limit - 1 ? 0 : r + 1;
            size++;
            return true;
        }
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }else {
            l = l == limit - 1 ? 0 : l + 1;
            size--;
            return true;
        }

    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return queue[l];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        //     r
        //  r-1
        // r(0)
        //     ... limit - 1
        int rear = 0 == r ? (limit - 1) : (r - 1) ;
        return queue[rear];
    }

    public boolean isEmpty() {
        return 0 == size;
    }

    public boolean isFull() {
        return size == limit;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */