package Stack1;

public class Stack1<T> {

    public Object[] stack;
    public int size;

    // 同时在栈里的元素个数不会超过n
    public Stack1(int n) {
        stack = new Object[n];
        size = 0;
    }

    // 调用任何方法之前，先调用这个方法来判断栈内是否有东西
    public boolean isEmpty() {
        return 0 == size;
    }

    public void push(T val) {
        stack[size++] = val;
    }

    public T pop() {
        return (T) stack[--size];
    }

    public T peek() {
        return (T) stack[size - 1];
    }

    public int size() {
        return this.size;
    }
}
