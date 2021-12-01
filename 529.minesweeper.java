/*
 * @lc app=leetcode id=529 lang=java
 *
 * [529] Minesweeper
 */

// @lc code=start
class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {

        int clickR = click[0], clickC = click[1];
        if (board[clickR][clickC] == 'M') { // A mine is revealed
            board[clickR][clickC] = 'X';

        } else {
            int count = countAdjacentMines(board, click);

            if (count > 0) {
                board[clickR][clickC] = (char)(48 + count);

            } else {
                board[clickR][clickC] = 'B';
                exploreAdjacentSquares(board, click);

            }
        }

        return board;
        
    }

    private int countAdjacentMines(char[][] board, int[] click) {
        int clickR = click[0], clickC = click[1];
        int iMax = board.length, jMax = board[0].length;

        int adjacentMines = 0;

        for (int i = clickR-1; i <= clickR+1; i++) {
            for (int j = clickC-1; j <= clickC+1; j++) {
                if (i == clickR && j == clickC) continue;
                if (!(i >= 0 && i < iMax && j >= 0 && j < jMax)) continue;
                if (board[i][j] == 'M') adjacentMines++;
            }
        }

        return adjacentMines;
    }

    private void exploreAdjacentSquares(char[][] board, int[] click) {
        int clickR = click[0], clickC = click[1];
        int iMax = board.length, jMax = board[0].length;

        for (int i = clickR-1; i <= clickR+1; i++) {
            for (int j = clickC-1; j <= clickC+1; j++) {
                if (i == clickR && j == clickC) continue;
                if (!(i >= 0 && i < iMax && j >= 0 && j < jMax)) continue;
                if (board[i][j] == 'E') updateBoard( board, new int[] { i, j } );
            }
        }
    }

}
// @lc code=end

