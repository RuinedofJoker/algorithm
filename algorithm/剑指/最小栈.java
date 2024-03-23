package 剑指;

import java.util.Stack;

/**
 * LCR 147. 最小栈
 */
public class 最小栈 {

    class MinStack {

        Stack<Integer> stack1;
        Stack<Integer> stack2;

        /** initialize your data structure here. */
        public MinStack() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int x) {
            stack1.push(x);
            if (stack2.isEmpty() || stack2.peek() >= x) {
                stack2.push(x);
            }
        }

        public void pop() {
            Integer pop = stack1.pop();
            if (!stack2.isEmpty() && stack2.peek().equals(pop)) {
                stack2.pop();
            }
        }

        public int top() {
            return stack1.peek();
        }

        public int getMin() {
            return stack2.peek();
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
}
