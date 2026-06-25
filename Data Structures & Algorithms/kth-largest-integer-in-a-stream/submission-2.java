class KthLargest {
    private int k;
    private PriorityQueue<Integer>pq;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        this.k = k;
        for (int num : nums) {
        pq.offer(num);
        if (pq.size() > k) {
            pq.poll();
        }
            }
    }
    
    public int add(int val) {
    if (pq.size() < k) {
        pq.offer(val);
    } else if (val > pq.peek()) {
        pq.poll();
        pq.offer(val);
    }

    return pq.peek();
}
}
