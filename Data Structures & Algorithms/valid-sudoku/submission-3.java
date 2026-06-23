public class Solution{
    public boolean isValidSudoku(char[][]board){
        int m = board.length;
        int[]rows = new int[m];
        int[]cols = new int[m];
        int[]boxes = new int[m];

        for(int row = 0; row < m; row++){
            for(int col = 0; col < m; col++){
                char place = board[row][col];
                if(place == '.'){
                    continue;
                }
                int bit = 1 << (place - '1');
                int box = (row/3) * 3 + (col/3);

                if((rows[row] & bit) != 0 || (cols[col] & bit) != 0 || (boxes[box] & bit) != 0){
                    return false;
                }
                rows[row] |= bit;
                cols[col] |= bit;
                boxes[box] |= bit;

            }
        }
        return true;
    }
}