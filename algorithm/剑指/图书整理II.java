package 剑指;

import java.util.Stack;

/**
 * LCR 125. 图书整理 II
 */
public class 图书整理II {
    class CQueue {

        Stack<Integer> stack;

        public CQueue() {
            stack = new Stack<>();
        }

        public void appendTail(int value) {
            stack.push(value);
        }

        public int deleteHead() {
            return stack.isEmpty() ? -1 : stack.pop();
        }
    }

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
}
