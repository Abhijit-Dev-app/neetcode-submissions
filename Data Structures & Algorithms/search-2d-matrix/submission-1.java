class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == target) {
                return true;
            }

            if (matrix[i][0] > target) {
                row = i - 1;
                break;
            }
        }

        if (row < 0) {
            return false;
        }

        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[row][j] == target) {
                return true;
            }
        }

        return false;
    }
}