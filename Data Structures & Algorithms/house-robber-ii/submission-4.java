class Solution {
    public int rob(int[] nums) {

        int n = nums.length;

        if (n == 1)
            return nums[0];

        int[] dp = new int[n];
        dp[0] = nums[0];

        for (int i = 1; i < n - 1; i++) {
            int take = nums[i];
            if (i > 1)
                take += dp[i - 2];

            dp[i] = Math.max(dp[i - 1], take);
        }

        int[] dp1 = new int[n];
        dp1[1] = nums[1];

        for (int i = 2; i < n; i++) {
            int take = nums[i];
            if (i > 2)
                take += dp1[i - 2];

            dp1[i] = Math.max(dp1[i - 1], take);
        }

        return Math.max(dp[n - 2], dp1[n - 1]);
    }
}