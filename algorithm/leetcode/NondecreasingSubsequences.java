package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 491. 递增子序列
 *
 * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
 *
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 *
 * 示例 1：
 * 输入：nums = [4,6,7,7]
 * 输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
 *
 * 示例 2：
 * 输入：nums = [4,4,3,2,1]
 * 输出：[[4,4]]
 *
 * 提示：
 * 1 <= nums.length <= 15
 * -100 <= nums[i] <= 100
 */
public class NondecreasingSubsequences {
    public static void main(String[] args) {
        new NondecreasingSubsequences().findSubsequences(new int[]{4,4,3,2,1});
    }
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> current = new ArrayList<>();
    Set<String> set = new HashSet<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        getSubsequences(nums, 0);
        return result;
    }

    void getSubsequences(int[] nums, int i) {
        if (current.size() >= 2) {
            List<Integer> probablyR = new ArrayList<>();
            for (int num = 0; num < current.size(); num++) {
                if (probablyR.size() == 0) {
                    probablyR.add(current.get(num));
                }else {
                    if (current.get(num) >= probablyR.get(probablyR.size() - 1)) {
                        probablyR.add(current.get(num));
                    }
                }
            }
            if (!set.contains(probablyR.toString()) && probablyR.size() >= 2) {
                result.add(probablyR);
                set.add(probablyR.toString());
            }
        }

        for (int j = i; j < nums.length; j++) {
            current.add(nums[j]);
            getSubsequences(nums, j + 1);
            current.remove(current.size() - 1);
        }
    }
}
