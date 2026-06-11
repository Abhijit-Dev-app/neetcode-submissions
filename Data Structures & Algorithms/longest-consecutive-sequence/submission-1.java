class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        int outSof = 0;
        int result = 0;
        HashSet<Integer>hs = new HashSet<>();
        for(int i = 0;i<n;i++){
            hs.add(nums[i]);
        }
        for(int i = 0;i<nums.length;i++){
            int cur = nums[i];
            if(hs.contains(cur - 1)){
                continue;
            }else{
                while(hs.contains(cur)){
                    outSof++;
                    cur = cur + 1;
                }
            }
            result = Math.max(result, outSof);
            outSof = 0;
        }
        return result;
    }
}
// HashMap<Integer, Integer>
// <2, 0>
// <20, 1>
// <4, 2>
// <10, 3>
// <3, 4>
// <4, 5>
// <5, 6>
