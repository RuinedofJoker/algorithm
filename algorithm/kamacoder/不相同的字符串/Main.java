package kamacoder.不相同的字符串;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lineNum = scanner.nextInt();
        for (int i = 0; i < lineNum; i++) {
            String s = scanner.nextLine();
            System.out.println(getOpsNum(s));
        }
        
    }

    static int getOpsNum(String s) {
        Map<Character, Integer> cMap = new HashMap<>(32);
        for (int i = 0; i < 26; i++) {
            cMap.put((char) ('a' + i), 0);
        }
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            cMap.put(aChar, cMap.get(aChar) + 1);
        }

        return 1;
    }
}
