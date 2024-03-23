package kamacoder.平均绩点;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>(){{
            put("A", 4);
            put("B", 3);
            put("C", 2);
            put("D", 1);
            put("F", 0);
        }};
        while (scanner.hasNextLine()) {
            String[] s = scanner.nextLine().split(" ");
            float avg = 0;
            boolean flag = true;
            for (int i = 0; i < s.length; i++) {
                if (!map.containsKey(s[i])) {
                    System.out.println("Unknown");
                    flag = false;
                    break;
                }
                avg += map.get(s[i]);
            }
            if (flag) {
                System.out.println(String.format("%.2f", avg / s.length));
            }
        }
    }
}
