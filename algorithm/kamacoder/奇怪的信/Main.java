package kamacoder.奇怪的信;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            int sum = 0;
            for (int i = 0; i < s.length(); i++) {
                int currentNum = Integer.parseInt(s.charAt(i) + "");
                sum += (currentNum % 2  == 0 ? currentNum : 0);
            }
            System.out.println(sum + "\r\n");
        }
    }
}
