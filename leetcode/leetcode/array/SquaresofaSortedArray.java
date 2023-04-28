package leetcode.array;

/**
 * 977. 有序数组的平方
 *
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 * 示例 1：
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 *
 * 示例 2：
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *
 * 提示：
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 已按 非递减顺序 排序
 *
 * 进阶：
 * 请你设计时间复杂度为 O(n) 的算法解决本问题
 */
public class SquaresofaSortedArray {
    public static void main(String[] args) {
        int[] ints = new SquaresofaSortedArray().sortedSquares(new int[]{-4, -1, 0, 3, 10});
        for (int i : ints){
            System.out.println(i);
        }
    }
    public int[] sortedSquares(int[] nums) {
        int minIndex = 0;
        for (int i = 1; i < nums.length; i++){
           if (Math.abs(nums[minIndex]) > Math.abs(nums[i])) {
               minIndex = i;
           }
        }

        int[] result = new int[nums.length];
        int left = minIndex - 1;
        int right = minIndex + 1;
        result[0] = (int) Math.pow(Math.abs(nums[minIndex]), 2);

        int i = 1;
        while (left >=0 || right < result.length) {
            if (left >= 0 && right < result.length) {
                if (Math.pow(Math.abs(nums[left]), 2) < Math.pow(Math.abs(nums[right]), 2)) {
                    result[i] = (int) Math.pow(Math.abs(nums[left]), 2);
                    left--;
                }else {
                    result[i] = (int) Math.pow(Math.abs(nums[right]), 2);
                    right++;
                }
            }else if (left >= 0 && right >= result.length) {
                result[i] = (int) Math.pow(Math.abs(nums[left]), 2);
                left--;
            }else {
                result[i] = (int) Math.pow(Math.abs(nums[right]), 2);
                right++;
            }
            i++;
        }
        return result;
    }
}
