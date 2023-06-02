package leetcode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 77. 组合
 *
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 *
 * 示例 1：
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 示例 2：
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 *
 * 提示：
 * 1 <= n <= 20
 * 1 <= k <= n
 */
public class Combinations {
    public static void main(String[] args) {
        System.out.println(new Combinations().combine(4, 2));
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentNum = new ArrayList<>();
        dfs(result, currentNum, 1, n + 1, k);
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> currentNum, int cur, int n, int k) {
        for (int i = cur; i <= n; i++) {
            if (currentNum.size() != k) {
                currentNum.add(i);
                dfs(result, currentNum, i + 1, n, k);
                currentNum.remove(currentNum.size() - 1);
            }else {
                result.add(currentNum.stream().toList());
                return;
            }
        }
    }
}
