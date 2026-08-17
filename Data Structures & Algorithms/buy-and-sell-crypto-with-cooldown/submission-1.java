class Solution {
    public int maxProfit(int[] prices) {
        int[][]dp = new int[prices.length][2];
        return Solver(prices, 0, 1, dp);
        
    }

    // public int Solver(int[]prices, int i, boolean buy){
    //     if(i >= prices.length){
    //         return 0;
    //     }

    //     if(buy){
    //         return Math.max(-prices[i] + Solver(prices, i + 1, false), Solver(prices, i + 1, true));
    //     }else{
    //         return Math.max(prices[i] + Solver(prices, i + 2, true), Solver(prices, i + 1,  false));
    //     }
    // }

    public int Solver(int[]prices, int i, int buy, int[][]dp){
        if(i >= prices.length){
            return 0;
        }
        if(dp[i][buy] != 0){
            return dp[i][buy];
        }

        if(buy == 1){
            dp[i][buy] =  Math.max(-prices[i] + Solver(prices, i + 1, 0, dp), Solver(prices, i + 1, 1, dp));
        }else{
            dp[i][buy] = Math.max(prices[i] + Solver(prices, i + 2, 1, dp), Solver(prices, i + 1,  0, dp));
        }

        return dp[i][buy];
    }
}
