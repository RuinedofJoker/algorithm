package leetcode.double_pointer;

/**
 * 541. 反转字符串 II
 *
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 *
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 * 示例 1：
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 *
 * 示例 2：
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 *
 * 提示：
 * 1 <= s.length <= 104
 * s 仅由小写英文组成
 * 1 <= k <= 104
 */
public class ReverseStringII {
    public static void main(String[] args) {
        System.out.println(new ReverseStringII().reverseStr("abcdefg", 2));
    }
    public String reverseStr(String s, int k) {
        int changeIndex = 0;
        boolean isChange = true;
        char[] sc = s.toCharArray();

        while (changeIndex < s.length() - 1) {
            if (isChange) {
                int left = changeIndex;
                int right = Math.min(s.length() - 1, left + k - 1);

                while (left < right) {
                    char temp = sc[left];
                    sc[left] = sc[right];
                    sc[right] = temp;
                    left++;
                    right--;
                }
            }
            isChange = !isChange;
            changeIndex = changeIndex + k;
        }

        return new String(sc);
    }
}
