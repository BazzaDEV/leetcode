/*
 * @lc app=leetcode id=529 lang=c
 *
 * [529] Minesweeper
 */

// @lc code=start

/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */
char **updateBoard(char **board, int boardSize, int *boardColSize, int *click, int clickSize, int *returnSize, int **returnColumnSizes)
{

    int row = click[0], col = click[1];

    *returnSize = boardSize;

    (*returnColumnSizes) = (int *)calloc(*returnSize, sizeof(int));
    for (int i = 0; i < *returnSize; i++) (*returnColumnSizes)[i] = boardColSize[i];

    if (board[row][col] == 'M') board[row][col] = 'X';
    else explore(board, boardSize, boardColSize[0], row, col);

    return board;
}

int countAdjacentMines(char **board, int boardSize, int boardColSize, int row, int col) {
    int count = 0;

    for (int i = row-1; i <= row+1; i++) {
        for (int j = col-1; j <= col+1; j++) {
            if (i == row && j == col) continue;
            if (i < 0 || i >= boardSize || j < 0 || j >= boardColSize) continue;
            if (board[i][j] == 'M') count++;
        }
    }

    return count;
}

void explore(char **board, int boardSize, int boardColSize, int row, int col)
{
    if (board[row][col] == 'M') {
        board[row][col] = 'X';
    } else {
        int adjMines = countAdjacentMines(board, boardSize, boardColSize, row, col);

        if (adjMines > 0) {
            board[row][col] = 48 + adjMines;
        } else {
            board[row][col] = 'B';
            for (int i = row-1; i <= row+1; i++) {
                for (int j = col-1; j <= col+1; j++) {
                    if (i == row && j == col) continue;
                    if (i < 0 || i >= boardSize || j < 0 || j >= boardColSize) continue;
                    if (board[i][j] == 'E') explore(board, boardSize, boardColSize, i, j);
                }
            }
        }
        
    }
}

// @lc code=end
