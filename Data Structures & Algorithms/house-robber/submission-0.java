class Solution {
    public int rob(int[] nums) {
        int[]dp = new int[nums.length];
        dp[0] = nums[0];
        int prev = 0;
        for(int i = 1; i < nums.length;i++){
            dp[i] = Math.max(dp[i - 1], prev + nums[i]);
            prev = dp[i - 1];
        }
        return dp[nums.length - 1];
    }
}
