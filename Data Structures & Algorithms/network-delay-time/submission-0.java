class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[]graph = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        PriorityQueue<int[]>pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for(int[]edg: times){
            graph[edg[0]].add(new int[]{edg[1], edg[2]});
        }
        int[]dist = new int[n + 1];
        for(int i = 0; i<= n; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[k] = 0;
        pq.offer(new int[]{k , 0});

        while(!pq.isEmpty()){
            int[]curr = pq.poll();
            int currNode = curr[0];
            int currDist = curr[1];

            if(currDist > dist[currNode]){
                continue;
            }

            for(int[]neigh: graph[currNode]){
                int nextNode = neigh[0];
                int weight = neigh[1];

                if(dist[nextNode] > currDist + weight){
                    dist[nextNode] = currDist + weight;
                    pq.offer(new int[]{nextNode, dist[nextNode]});
                }
            }
        }
        int max = 0;
        for(int i = 1; i <= n; i++){
            if(dist[i] == Integer.MAX_VALUE){
                return -1;
            }
            max = Math.max(max, dist[i]);
        }
        return max;
    }
}
