package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. N 皇后
 *
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 *
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 *
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 示例 1：
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：[["Q"]]
 *
 * 提示：
 * 1 <= n <= 9
 */
public class NQueens {
    public static void main(String[] args) {
        new NQueens().solveNQueens(4);
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        List<String> chessboard = new ArrayList<>();
        putQueen(result, chessboard, n);
        return result;
    }
    void putQueen(List<List<String>> result, List<String> chessboard, int n) {

        int currentLineNum = chessboard.size();
        //满足条件
        if (currentLineNum == n) {
            result.add(chessboard.stream().toList());
            return;
        }

        for (int i = 0; i < n; i++) {
            StringBuilder builder = new StringBuilder();
            for (int pot = 0; pot < n; pot++) {
                if (pot == i) {
                    builder.append("Q");
                }else {
                    builder.append(".");
                }
            }

            boolean canPut = true;
            int b1 = currentLineNum - i;
            int b2 = currentLineNum + i;
            for (int j = 0; j < chessboard.size(); j++) {
                String beforeChess = chessboard.get(j);
                if (beforeChess.charAt(i) == 'Q' || (j - b1 >= 0 && beforeChess.charAt(j - b1) == 'Q') || (b2 - j < beforeChess.length() && beforeChess.charAt(b2 - j) == 'Q')) {
                    canPut = false;
                    break;
                }
            }

            if (canPut) {
                chessboard.add(builder.toString());
            }else {
                continue;
            }
            putQueen(result, chessboard, n);
            chessboard.remove(chessboard.size() - 1);
        }
    }
}
