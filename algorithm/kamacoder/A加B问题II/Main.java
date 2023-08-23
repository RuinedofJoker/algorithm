package kamacoder.A加B问题II;

import java.util.Scanner;

/**
 * 2. A+B问题II
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int i = in.nextInt();
            while (i-- > 0) {
                int a = in.nextInt();
                int b = in.nextInt();
                System.out.println(a + b);
            }
        }
    }
}
