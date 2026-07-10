
class Solution {
    private int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};

    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] LIP = new int[rows][cols];

        int ans = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ans = Math.max(ans, dfs(matrix, LIP, i, j, rows, cols));
            }
        }

        return ans;
    }

    private int dfs(int[][] matrix, int[][] LIP, int row, int col, int rows, int cols) {

        if (LIP[row][col] != 0) {
            return LIP[row][col];
        }

        int ans = 1;

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow < 0 || newRow >= rows ||
                newCol < 0 || newCol >= cols ||
                matrix[newRow][newCol] <= matrix[row][col]) {
                continue;
            }

            ans = Math.max(ans, 1 + dfs(matrix, LIP, newRow, newCol, rows, cols));
        }

        LIP[row][col] = ans;
        return ans;
    }
}