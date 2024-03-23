package kamacoder.A加B问题IV;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String[] s = scanner.nextLine().split(" ");
            int sum = 0;
            for (int i = 1; i < s.length; i++) {
                sum += Integer.parseInt(s[i]);
            }
            if (sum == 0) {
                return;
            }
            System.out.println(sum);
        }
    }
}
