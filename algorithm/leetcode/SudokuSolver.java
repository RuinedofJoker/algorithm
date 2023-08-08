package leetcode;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 37. 解数独
 *
 * 编写一个程序，通过填充空格来解决数独问题。
 *
 * 数独的解法需 遵循如下规则：
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 *
 * 示例 1：
 * 输入：board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
 * 输出：[["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
 * 解释：输入的数独如上图所示，唯一有效的解决方案如下所示：
 *
 * 提示：
 * board.length == 9
 * board[i].length == 9
 * board[i][j] 是一位数字或者 '.'
 * 题目数据 保证 输入数独仅有一个解
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        AtomicBoolean isFind = new AtomicBoolean(false);
        putSudoku(board, 0, 0, isFind);
    }
    void putSudoku(char[][] board, int x, int y, AtomicBoolean isFind) {
        if (x == 9 && y == 9) {
            isFind.set(true);
            return;
        }

        boolean isPot = board[x][y] == '.';
        if (isPot) {
            for (int i = 1; i <= 9; i++) {
                //判断如果落子是否满足条件
                boolean canPut = true;
                //竖轴判断
                for (int px = 0; px < 9; px++) {
                    if (board[px][y] == Integer.toString(i).charAt(0)) {
                        canPut = false;
                        break;
                    }
                }
                //横轴判断
                for (int py = 0; py < 9 && canPut; py++) {
                    if (board[x][py] == Integer.toString(i).charAt(0)) {
                        canPut = false;
                        break;
                    }
                }
                //同区判断
                for (int px = region(x); px < region(x) + 3 && canPut; px++) {
                    for (int py = region(y); py < region(y) + 3; py++) {
                        if (board[px][py] == Integer.toString(i).charAt(0)) {
                            canPut = false;
                            break;
                        }
                    }
                }
                //是落子递归
                if (canPut) {
                    board[x][y] = Integer.toString(i).charAt(0);
                    if (x < 8) {
                        putSudoku(board, x + 1, y, isFind);
                    }else {
                        if (y < 8) {
                            putSudoku(board, 0 , y + 1, isFind);
                        }else {
                            putSudoku(board, 9 , 9, isFind);
                        }
                    }
                }else {
                    continue;
                }
                if (isFind.get()) {
                    return;
                }
                board[x][y] = '.';
            }
        }else {
            if (x < 8) {
                putSudoku(board, x + 1, y, isFind);
            }else {
                if (y < 8) {
                    putSudoku(board, 0 , y + 1, isFind);
                }else {
                    putSudoku(board, 9 , 9, isFind);
                }
            }
        }
    }
    int region(int n) {
        if (n < 3) {
            return 0;
        }else if (n < 6) {
            return 3;
        }else {
            return 6;
        }
    }
}
