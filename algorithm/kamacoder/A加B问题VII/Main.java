package kamacoder.A加B问题VII;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int sum = 0;
            sum += scanner.nextInt();
            sum += scanner.nextInt();
            System.out.println(sum + "\r\n");
        }
    }
}
