// 用栈实现队列
https://leetcode.cn/problems/implement-queue-using-stacks/

import java.util.Stack;

class MyQueue {

    // 得用两个栈来实现
    public Stack<Integer> in = new Stack<>();
    public Stack<Integer> out = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
        // 入 in 栈
        in.push(x);
    }

    // 将 in栈数据 导入 out栈
    private void inToOut() {
        // out栈为空, 才能往里倒数据
        if (out.empty()) {
            while (!in.empty()) {
                out.push(in.pop());
            }
        }
    }

    public int pop() {
        inToOut();
        return out.pop();
    }

    public int peek() {
        inToOut();
        return out.peek();
    }

    public boolean empty() {
        return in.empty() && out.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */