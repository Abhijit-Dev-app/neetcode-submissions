class Solution {
    // private int[][]directions;
    public int uniquePaths(int m, int n) {
        // directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][]dp =  new int[m][n];
        return Solver(dp);
    }

    public int Solver(int[][]dp){
        dp[dp.length - 1][dp[0].length - 1] = 1;
        for(int i = dp[0].length - 2; i >=0 ; i--){
            dp[dp.length - 1][i] = dp[dp.length - 1][i + 1];
        } 

        for(int i = dp.length - 2; i >= 0; i--){
            dp[i][dp[0].length - 1] = dp[i + 1][dp[0].length - 1];
        }

        for(int i = dp.length - 2; i >= 0; i--){
            for(int j = dp[0].length - 2; j >= 0; j--){
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[0][0];
    }
}
