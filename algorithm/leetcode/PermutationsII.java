package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 *
 * 示例 2：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * 提示：
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 */
public class PermutationsII {
    public static void main(String[] args) {
        new PermutationsII().permuteUnique(new int[]{1,3,2});
    }
    List<List<Integer>> result;
    List<Integer> current;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        result = new ArrayList<>();
        current = new ArrayList<>();
        addNum(nums, new boolean[nums.length], 0);
        return result;
    }

    void addNum(int[] nums, boolean[] used, int index) {
        if (current.size() == nums.length) {
            result.add(current.stream().toList());
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                if ((i != 0 && nums[i] == nums[i - 1]) && !used[i - 1]) {
                    continue;
                }else {
                    current.add(nums[i]);
                    used[i] = true;
                    addNum(nums, used, i);
                    current.remove(current.size() - 1);
                    used[i] = false;
                }
            }
        }
    }
}
