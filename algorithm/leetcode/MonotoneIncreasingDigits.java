package leetcode;

/**
 * 738. 单调递增的数字
 *
 * 当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。
 *
 * 给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。
 *
 * 示例 1:
 * 输入: n = 10
 * 输出: 9
 *
 * 示例 2:
 * 输入: n = 1234
 * 输出: 1234
 *
 * 示例 3:
 * 输入: n = 332
 * 输出: 299
 *
 *
 * 提示:
 *
 * 0 <= n <= 109
 */
public class MonotoneIncreasingDigits {
    public static void main(String[] args) {
        System.out.println(new MonotoneIncreasingDigits().monotoneIncreasingDigits(120));
    }
    public int monotoneIncreasingDigits(int n) {
        String[] nToStr = (n + "").split("");
        int start = nToStr.length;
        for (int i = start - 1; i > 0; i--) {
            if (Integer.parseInt(nToStr[i]) < Integer.parseInt(nToStr[i - 1])) {
                nToStr[i - 1] = (Integer.parseInt(nToStr[i - 1]) - 1) + "";
                start = i;
            }
        }

        for (int i = start; i < nToStr.length; i++) {
            nToStr[i] = "9";
        }

        return Integer.parseInt(String.join("", nToStr));
    }
}
