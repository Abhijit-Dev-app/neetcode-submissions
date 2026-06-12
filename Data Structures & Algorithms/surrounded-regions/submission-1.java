class Solution {
    private int[][] directions = {
        {0,1},{1,0},{0,-1},{-1,0}
    };

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++) {
            dfs(i, 0, board);
            dfs(i, n - 1, board);
        }

        for(int j = 0; j < n; j++) {
            dfs(0, j, board);
            dfs(m - 1, j, board);
        }

        // Convert surrounded regions
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if(board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(int row, int col, char[][] board) {
        if(row < 0 || row >= board.length ||
           col < 0 || col >= board[0].length ||
           board[row][col] != 'O') {
            return;
        }

        board[row][col] = '#';

        for(int[] dir : directions) {
            dfs(row + dir[0], col + dir[1], board);
        }
    }
}