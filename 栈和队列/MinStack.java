https://leetcode.cn/problems/min-stack/submissions/524514559/

import java.util.Objects;
import java.util.Stack;

// 1. 集合类实现 最小栈

class MinStack1 {

    public Stack<Integer> data = new Stack<>();
    public Stack<Integer> min = new Stack<>();

    public MinStack1() {

    }

    public void push(int val) {
        data.push(val);
        if (min.isEmpty() || val <= min.peek()) {
            min.push(val);
        }else {
            min.push(min.peek());
        }
    }

    public void pop() {
        data.pop();
        min.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return min.peek();
    }
}

// 2. 自己用数组实现 最小栈

class MinStack {

    // 最大数据个数
    public static final int MAX_N = 8001;
    public int[] data = new int[MAX_N];
    public int[] min = new int[MAX_N];
    public int size;

    public MinStack() {

    }

    public void push(int val) {
        data[size] = val;
        if (size == 0 || val <= min[size - 1]) {
            min[size] = val;
        }else {
            min[size] = min[size - 1];
        }
        size++;
    }

    public void pop() {
        size--;
    }

    public int top() {
        return data[size - 1];
    }

    public int getMin() {
        return min[size - 1];
    }
}

