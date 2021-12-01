#
# @lc app=leetcode id=529 lang=python3
#
# [529] Minesweeper
#

# @lc code=start
class Solution:
    def updateBoard(self, board: List[List[str]], click: List[int]) -> List[List[str]]:
        row = click[0]
        col = click[1]

        if board[row][col] == 'M':
            board[row][col] = 'X'
        else:
            self.explore(board, row, col)
        
        return board


    def explore(self, board: List[List[str]], row: int, col: int):

        if board[row][col] == 'M':
            board[row][col] = 'X'
        else:
            count = self.countAdjacentMines(board, row, col)

            if count > 0:
                board[row][col] = str(count)
            else:
                board[row][col] = "B"
                for i in range(row-1, row+2):
                    for j in range(col-1, col+2):
                        if i == row and j == col: 
                            continue
                        if i < 0 or i >= len(board) or j < 0 or j >= len(board[0]): 
                            continue
                        if board[i][j] == 'E':
                            self.explore(board, i, j)


    def countAdjacentMines(self, board: List[List[str]], row: int, col: int):
        count = 0

        for i in range(row-1, row+2):
            for j in range(col-1, col+2):
                if i == row and j == col: 
                    continue
                if i < 0 or i >= len(board) or j < 0 or j >= len(board[0]): 
                    continue
                if board[i][j] == 'M':
                    count += 1
        
        return count
# @lc code=end

