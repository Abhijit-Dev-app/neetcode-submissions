class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer>hm = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            int current = nums[i];
            int x = target - current;
            if(hm.containsKey(x)){
                return new int[]{hm.get(x), i};
            }
            hm.put(current, i);
        }
        return new int[]{};
    }
}
