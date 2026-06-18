class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]>pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int n = points.length;
        List<int[]>[]graph = new ArrayList[n];
        for(int i = 0; i< n; i++){
            graph[i] = new ArrayList<>();
        }

        // Building Adjacency List
        for(int row = 0; row < n; row++){
            int x1 = points[row][0];
            int y1 = points[row][1];
            for(int col = row + 1; col < n; col++){
                int x2 = points[col][0];
                int y2 = points[col][1];
                int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                graph[row].add(new int[]{dist, col});
                graph[col].add(new int[]{dist, row});
            }
        }
        HashSet<Integer>visited = new HashSet<>();
        // visted set to keep track of already visited edges
        int cost = 0;
        pq.add(new int[]{0, 0}); // initializing pq with first node which is(0) with dist 0

        // loop will run untill all the nodes are visited 
        while(visited.size() < n){
            int[]curr = pq.poll();
            int dist = curr[0];
            int node = curr[1];

            if(visited.contains(node)){
                continue;
            }
            visited.add(node);
            cost += dist;

            for(int[]neigh: graph[node]){
                if(!visited.contains(neigh[1])){
                    pq.offer(new int[]{neigh[0], neigh[1]});
                }
            }
        }
        return cost;
    }
}
