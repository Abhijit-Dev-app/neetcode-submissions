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

// class Solution{
//     class UnionFind{
//         int[]parent;
//         UnionFind(int n){
//             parent = new int[n];
//             for(int i = 0;i<n;i++){
//                 parent[i] = i;
//             }
//         }
//         int find(int a){
//             if(parent[a] != a){
//                 parent[a] = find(parent[a]);
//             }
//             return parent[a];
//         }
//         boolean union(int a, int b){
//             int p1 = find(a);
//             int p2 = find(b);

//             if(p1 == p2){
//                 return false;
//             }
//             parent[p2] = p1;
//             return true;
//         }
//     }
//     public int countComponents(int n, int[][]edges){
//         Set<Integer>visited = new HashSet<>();
//         UnionFind uf = new UnionFind(n);
//         int count = 0;
//         for(int[]uedg: edges){
//             int fd = uf.find(uedg[0]);
//             if(fd == uedg[0] && !visited.contains(uedg[0])){
//                 visited.add(uedg[0]);
//                 count++;
//             }
//             visited.add(uedg[0]);
//             uf.union(uedg[0], uedg[1]);   
//         }
//         return count;
//     }
// }
