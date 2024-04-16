package Queue2;

// 静态数组实现的队列
public class Queue2<T> {
    public Object[] queue;
    public int l;
    public int r;

    // 加入操作的总次数上限是多少，一定要明确
    public Queue2(int n) {
        queue = new Object[n];
    }

    public boolean isEmpty() {
       return l == r;
    }

    public void offer(T val) {
        queue[r++] = val;
    }

    public T poll() {
        T ret = (T) queue[l++];
        return ret;
    }

    //
    public T head() {
        return (T) queue[l];
    }

    public T tail() {
        return (T) this.queue[r - 1];
    }

    public int size() {
        return r - l;
    }

}
