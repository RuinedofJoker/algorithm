package leetcode.array;

/**
 * 59. 螺旋矩阵 II
 *
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：[[1]]
 *
 * 提示：
 * 1 <= n <= 20
 */
public class SpiralMatrixII {
    public static void main(String[] args) {
        int[][] ints = new SpiralMatrixII().generateMatrix(3);
        for (int is[] : ints) {
            for (int i : is) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];

        int row = 0;
        int col = 0;
        int minRow = 1;
        int minCol = 0;
        int maxRow = n - 1;
        int maxCol = n - 1;
        boolean isRowAdd = false;
        boolean isRowSub = false;
        boolean isColAdd = true;
        boolean isColSub = false;

        for (int i = 1; i <= Math.pow(n, 2); i++) {
            result[row][col] = i;
            if (isColAdd) {
                if (col == maxCol) {
                    isColAdd = false;
                    isRowAdd = true;
                    maxCol--;
                    row++;
                }else {
                    col++;
                }
            }else if (isRowAdd) {
                if (row == maxRow) {
                    isRowAdd = false;
                    isColSub = true;
                    maxRow--;
                    col--;
                }else {
                    row++;
                }
            }else if (isColSub) {
                if (col == minCol) {
                    isColSub = false;
                    isRowSub = true;
                    minCol++;
                    row--;
                }else {
                    col--;
                }
            }else if (isRowSub) {
                if (row == minRow) {
                    isRowSub = false;
                    isColAdd = true;
                    minRow++;
                    col++;
                }else {
                    row--;
                }
            }
        }

        return result;
    }
}
