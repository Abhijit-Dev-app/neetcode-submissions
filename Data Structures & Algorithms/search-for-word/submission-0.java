class Solution {
    // class pair{
    //     int i;
    //     int j;
    //     pair(int i, int j){
    //         this.i = i;
    //         this.j = j;
    //     }
    // }
    public int[][]directions;
    public boolean exist(char[][] board, String word) {
        directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean flag = false;
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(board[i][j] == word.charAt(0)){
                    if(Validation(board, word, directions, i, j, 0)){
                        return true;
                    }
                }
            }
        }
        return flag;
    }
    public boolean Validation(char[][]board, String word, int[][]directions,int row, int col, int index){
        if(word.length() == index){
            return true;
        }
        if(row >= board.length || col >= board[0].length || row < 0 || col < 0 || board[row][col] != word.charAt(index)){
                return false;
        }
        char temp = board[row][col];
        board[row][col] = '#';
        for(int[]dir: directions){
            int rowdash = row + dir[0];
            int coldash = col + dir[1];

            if(Validation(board, word, directions, rowdash, coldash, index + 1)){
                return true;
            }
        }
        board[row][col] = temp;
        return false;
    }
}
