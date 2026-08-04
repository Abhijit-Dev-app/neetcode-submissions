class Solution {
    private List<List<Integer>>result;
    public List<List<Integer>> subsets(int[] nums) {
        result  = new ArrayList<>();
        Helper(nums, new ArrayList<>(), 0);
        return result;
    }

    public void Helper(int[]nums, List<Integer>curr, int i){
        result.add(new ArrayList<>(curr));
        for(int j = i; j < nums.length; j++){
            curr.add(nums[j]);
            Helper(nums, curr, j + 1);
            curr.remove(curr.size() - 1);
        }
        return;
    }
}
