class Solution {
    List<List<Integer>>result;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        result = new ArrayList<List<Integer>>();
        List<Integer>cur = new ArrayList<Integer>();
        backtrack(nums, target, cur, 0);
        return result;
    }
    public void backtrack(int[]nums, int target, List<Integer> cur,int i){
        if(target == 0){
            result.add(new ArrayList(cur));
            return;
        }
        if(target < 0 || i >= nums.length){
            return;
        }
        cur.add(nums[i]);
        backtrack(nums, target - nums[i], cur, i);
        cur.remove(cur.size() - 1);
        backtrack(nums, target, cur, i + 1);
    }
}
