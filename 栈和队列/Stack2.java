import java.util.LinkedList;
import java.util.Queue;

// 1个队列实现栈
class MyStack {

    public Queue<Integer> stack = new LinkedList<>();

    public MyStack() {

    }

    // 必须得, 每入一个数, 就调用reEntry
    // O (N)
    public void push(int x) {
        stack.add(x);
        reEntry();
    }

    // n-1 个数据, 重新入队列
    private void reEntry() {
        int n = stack.size() - 1;
        while (n != 0) {
            stack.add(stack.poll());
            n--;
        }
    }


    public int pop() {
        return stack.poll();
    }

    public int top() {

        return stack.peek();
    }

    public boolean empty() {
        return 0 == stack.size();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */