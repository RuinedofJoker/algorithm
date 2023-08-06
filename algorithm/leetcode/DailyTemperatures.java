package leetcode;

import java.util.Stack;

/**
 * 739. 每日温度
 *
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 示例 1:
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 *
 * 示例 2:
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 *
 * 示例 3:
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 *
 * 提示：
 * 1 <= temperatures.length <= 105
 * 30 <= temperatures[i] <= 100
 */
public class DailyTemperatures {
    public static void main(String[] args) {
        System.out.println(new DailyTemperatures().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
    }
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures.length == 1)   return new int[]{0};

        int[] result = new int[temperatures.length];

        Stack<StackNode> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.empty() && stack.peek().value < temperatures[i]) {
                StackNode popNode = stack.pop();
                result[popNode.index] = i - popNode.index;
            }
            stack.push(new StackNode(temperatures[i], i));
        }

        return result;
    }
    static class StackNode {
        public int value;
        public int index;

        public StackNode(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
