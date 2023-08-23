package kamacoder.A加B问题III;

import java.util.Scanner;

/**
 * 3. A+B问题III
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int a = in.nextInt();
            int b = in.nextInt();
            if (a != 0 && b != 0) {
                System.out.println(a + b);
            }
        }
    }
}
