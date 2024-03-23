package kamacoder.出栈合法性;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int lineNums = scanner.nextInt();
            if (lineNums == 0) {
                break;
            }
            int[] stackNum = new int[lineNums];
            for (int i = 0; i < lineNums; i++) {
                stackNum[i] = scanner.nextInt();
            }

            Stack<Integer> stack = new Stack<>();
            boolean flag = true;
            int nextStackTop = 1;
            for (int i = 0; i < stackNum.length; i++) {
                while (stack.isEmpty() || stack.peek() != stackNum[i]) {
                    int pushNum = nextStackTop++;
                    if (stack.contains(pushNum) || nextStackTop > (stackNum.length + 1)) {
                        System.out.println("No");
                        flag = false;
                        break;
                    }
                    stack.push(pushNum);
                }
                if (!flag) {
                    break;
                }
                stack.pop();
            }

            if (flag) {
                System.out.println("Yes");
            }
        }
    }
}
