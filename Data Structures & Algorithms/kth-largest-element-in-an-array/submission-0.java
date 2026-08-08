class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer>pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        // 1, 2, 3, 4, 5

        for(int num: nums){
            pq.add(num);
        }
        // int count = 0;

        while(k > 1){
            pq.remove();
            k--;
        }
        return pq.peek();
    }
}
