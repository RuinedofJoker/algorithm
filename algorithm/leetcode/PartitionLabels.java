package leetcode;

import java.util.*;

/**
 * 763. 划分字母区间
 *
 * 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 *
 * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
 *
 * 返回一个表示每个字符串片段的长度的列表。
 *
 * 示例 1：
 * 输入：s = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 这样的划分是错误的，因为划分的片段数较少。
 *
 * 示例 2：
 * 输入：s = "eccbbbbdec"
 * 输出：[10]
 *
 * 提示：
 * 1 <= s.length <= 500
 * s 仅由小写英文字母组成
 */
public class PartitionLabels {
    public static void main(String[] args) {
        System.out.println(new PartitionLabels().partitionLabels("ababcbacadefegdehijhklij"));
    }
    public List<Integer> partitionLabels(String s) {
        char[] sc = s.toCharArray();
        Map<Character, int[]> sChars = new HashMap<>();

        for (int i = 0; i < sc.length; i++) {
            if (!sChars.containsKey(sc[i])) {
                int[] interval = new int[2];
                interval[0] = interval[1] = i;
                sChars.put(sc[i], interval);
            }else {
                sChars.get(sc[i])[1] = i;
            }
        }

        int[][] intervals = new int[sChars.size()][2];
        int index = 0;

        for (char key : sChars.keySet()) {
            intervals[index] = sChars.get(key);
            index++;
        }

        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });

        List<Integer> result = new ArrayList<>();
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] > right) {
                result.add(right - left + 1);
                left = intervals[i][0];
                right = intervals[i][1];
            }else {
                right = Math.max(right, intervals[i][1]);
            }
        }
        result.add(right - left + 1);

        return result;
    }
}
