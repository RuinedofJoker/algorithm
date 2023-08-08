package leetcode;

import java.util.*;

/**
 * 90. 子集 II
 *
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 * 示例 1：
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 *
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 * 提示：
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            getSubset(result, new HashSet<>(), new ArrayList<>(), nums, 0, i);
        }
        return result;
    }

    void getSubset(List<List<Integer>> result, Set<String> resultSet, List<Integer> currentSub, int[] nums, int index, int num) {
        if (currentSub.size() == num) {
            StringBuilder builder = new StringBuilder();
            for (int i : currentSub) {
                builder.append(i + ":");
            }
            if (!resultSet.contains(builder.toString())) {
                result.add(currentSub.stream().toList());
                resultSet.add(builder.toString());
            }
            return;
        }
        for (int i = index; i < nums.length; i++) {
            currentSub.add(nums[i]);
            getSubset(result, resultSet, currentSub, nums, i + 1, num);
            currentSub.remove(currentSub.size() - 1);
        }
    }
}
