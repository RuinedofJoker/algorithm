package 剑指;

/**
 * 剑指 Offer 58 - II. 左旋转字符串
 */
public class 左旋转字符串 {
    public String reverseLeftWords(String s, int n) {
        /*String left = s.substring(n);
        String right = s.substring(0, n);
        return left + right;*/
        StringBuilder result = new StringBuilder();
        for (int i = n; i < n + s.length(); i++) {
            result.append(s.charAt(i % s.length()));
        }

        return result.toString();
    }
}
