// class Solution {
//     public boolean validTree(int n, int[][] edges) {

//         if (edges.length != n - 1) {
//             return false;
//         }

//         List<Integer>[] graph = new ArrayList[n];
//         for (int i = 0; i < n; i++) {
//             graph[i] = new ArrayList<>();
//         }

//         for (int[] edge : edges) {
//             graph[edge[0]].add(edge[1]);
//             graph[edge[1]].add(edge[0]);
//         }

//         Set<Integer> visited = new HashSet<>();

//         if (!dfs(0, -1, graph, visited)) {
//             return false;
//         }

//         return visited.size() == n;
//     }

//     private boolean dfs(int node,
//                         int parent,
//                         List<Integer>[] graph,
//                         Set<Integer> visited) {

//         if (visited.contains(node)) {
//             return false;
//         }

//         visited.add(node);

//         for (int neighbor : graph[node]) {

//             if (neighbor == parent) {
//                 continue;
//             }

//             if (!dfs(neighbor, node, graph, visited)) {
//                 return false;
//             }
//         }

//         return true;
//     }
// }
class Solution {
    private int[]parent;
    public boolean validTree(int n, int [][]edges){
        if (edges.length != n - 1) {
            return false;
        }
        parent = new int[n];
        for(int i = 0;i<n;i++){
            parent[i] = i;
        }
        for(int[]neigh: edges){
            if(!union(neigh[0], neigh[1])){
                return false;
            }
        }
        return true;
    }
    public boolean union(int a, int b){
        int parent1 = parent(a);
        int parent2 = parent(b);

        if(parent1 == parent2){
            return false;
        }
        parent[parent2] = parent1;
        return true;
    }
    public int parent(int a){
        if(parent[a] != a){
            parent[a] = parent(parent[a]);
        }
        return parent[a];
    }
}