class Solution {
    public int countComponents(int n, int[][] edges) {
        List<Integer>[]graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        Set<Integer>visited = new HashSet<>();

        for(int[]uedg: edges){
            graph[uedg[0]].add(uedg[1]);
            graph[uedg[1]].add(uedg[0]);
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            if(!visited.contains(i)){
                count++;
                dfs(i, -1, visited, graph);
            }
        }
        return count;
    }
    public void dfs(int node, int parent, Set<Integer>visited, List<Integer>[]graph ){
        if(visited.contains(node)){
            return;
        }
        visited.add(node);
        for(int neigh: graph[node]){
            if(parent == neigh){
                continue;
            }
            dfs(neigh, node, visited, graph);
        }
        return;
    }
}
