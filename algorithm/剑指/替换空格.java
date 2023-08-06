package 剑指;

/**
 * 剑指 Offer 05. 替换空格
 */
public class 替换空格 {
    public String replaceSpace(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                builder.append("%20");
            }else {
                builder.append(s.charAt(i));
            }
        }

        return builder.toString();
    }
}
