class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int[]dp = new int[nums.length];
        dp[0] = nums[0];
        int prev = 0;
        for(int i = 1; i < nums.length - 1;i++){
            dp[i] = Math.max(dp[i - 1], prev + nums[i]);
            prev = dp[i - 1];
        }

        int[]dp1 = new int[nums.length];
        dp1[1] = nums[1];
        prev = 0;
        for(int i = 2; i < nums.length;i++){
            dp1[i] = Math.max(dp1[i - 1], prev + nums[i]);
            prev = dp1[i - 1];
        }


        return Math.max(dp[nums.length - 2], dp1[nums.length - 1]);
    }
}
