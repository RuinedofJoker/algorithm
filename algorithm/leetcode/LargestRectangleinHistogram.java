package leetcode;

import java.util.Stack;

/**
 * 84. 柱状图中最大的矩形
 *
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * 示例 1:
 * 输入：heights = [2,1,5,6,2,3]
 * 输出：10
 * 解释：最大的矩形为图中红色区域，面积为 10
 *
 * 示例 2：
 * 输入： heights = [2,4]
 * 输出： 4
 *
 * 提示：
 * 1 <= heights.length <=105
 * 0 <= heights[i] <= 104
 */
public class LargestRectangleinHistogram {
    public int largestRectangleArea(int[] heights) {
        int result = 0;

        int [] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        for (int index = 0; index < heights.length; index++){
            newHeights[index + 1] = heights[index];
        }
        heights = newHeights;

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 1; i < heights.length; i++) {
            if (heights[i] == heights[stack.peek()]){
                stack.pop();
            }else if (heights[i] < heights[stack.peek()]){
                while (heights[i] < heights[stack.peek()]) {
                    int mid = stack.pop();
                    int left = stack.peek();
                    int right = i;
                    int width = right - left - 1;
                    int height = heights[mid];
                    result = Math.max(result, width * height);
                }
            }
            stack.push(i);
        }

        return result;
    }
}
