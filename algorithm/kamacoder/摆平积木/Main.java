package kamacoder.摆平积木;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            int blockNum = scanner.nextInt();
            if (blockNum == 0) {
                break;
            }
            int[] blocks = null;
            int sum = 0;
            blocks = new int[blockNum];
            for (int i = 0; i < blocks.length; i++) {
                blocks[i] = scanner.nextInt();
                sum += blocks[i];
            }
            sum = sum / blocks.length;
            int result = 0;
            for (int i = 0; i < blocks.length; i++) {
                result += (Math.abs(blocks[i] - sum));
            }
            System.out.println(result / 2 + "\r\n");
        }
    }
}
