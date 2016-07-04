package Java;

import java.util.Stack;

/**
 * Two Stacks, one regular, one with order
 * push() pop() top() getMin() -- O(1)
 */

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minstack;

    public MinStack() {
        stack = new Stack<Integer>();
        minstack = new Stack<Integer>();
    }

    public void push(int x) {
        stack.push(x);
        if (minstack == null) {
            minstack.push(x);
        } else {
            minstack.push(Math.min(x, minstack.peek()));
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.pop();
    }

    public int getMin() {
        return minstack.pop();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */