package 剑指;

/**
 * LCR 181. 字符串中的单词反转
 */
public class 字符串中的单词反转 {
    public static void main(String[] args) {
        new 字符串中的单词反转().reverseMessage("a good   example");
    }
    public String reverseMessage(String message) {
        message = message.trim();
        StringBuilder builder = new StringBuilder();
        int wordRight = message.length() - 1;
        int i = wordRight;

        while (i >= 0) {
            while (i >= 0 && message.charAt(i) != ' ') {
                i--;
            }
            builder.append(message.substring(i + 1, wordRight + 1)).append(" ");
            while (i >= 0 && message.charAt(i) == ' ') {
                i--;
            }
            wordRight = i;
        }

        return builder.toString().trim();
    }
}
