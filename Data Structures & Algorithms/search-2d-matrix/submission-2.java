class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int find = -1;
        for(int i = 0; i< matrix.length; i++){
            if(matrix[i][0] == target){
                return true;
            }else if(matrix[i][0] > target){
                find = i - 1;
                break;
            }
        }
        if(find == -1){
            find = matrix.length - 1;
        }
        for(int i = 0; i < matrix[0].length; i++){
            if(matrix[find][i] == target){
                return true;
            }
        }
        return false;
    }
}
