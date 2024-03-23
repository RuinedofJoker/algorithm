package kamacoder.A加B问题VIII;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int lines = scanner.nextInt();
            for (int i = 0; i < lines; i++) {
                int nums = scanner.nextInt();
                int sum = 0;
                for (int j = 0; j < nums; j++) {
                    sum += scanner.nextInt();
                }
                System.out.println(sum + (i != lines - 1 ? "\r\n" : ""));
            }
        }
    }
}
