class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>>result = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, target, 0, 0, new ArrayList<>(), result);

        return result;
    }

    public void dfs(int[]nums, int target, int total, int i, List<Integer>cur, List<List<Integer>>result){
        if(total == target){
            result.add(new ArrayList<>(cur));
            return;
        }

        for(int j = i; j < nums.length; j++){
            if(total + nums[j] > target){
                return;
            }

            cur.add(nums[j]);
            dfs(nums, target, total + nums[j], j, cur, result);
            cur.remove(cur.size() - 1);
        }
    }
}
