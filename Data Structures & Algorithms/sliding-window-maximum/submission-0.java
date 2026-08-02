class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer>pq = new PriorityQueue<>((a, b)-> Integer.compare(b, a));

        int left = 0;
        int count = 0;
        int[]res = new int[nums.length - k + 1];
        for(int right = 0; right < nums.length; right++){
            pq.add(nums[right]);
            if((right - left + 1) > k){
                pq.remove(nums[left]);
                left++;
            }
            if((right  - left + 1) ==  k){
                res[count++] = pq.peek();
            }
        }
        return res;
    }
}



