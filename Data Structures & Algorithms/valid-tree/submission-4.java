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

    private int[] parent;

    public boolean validTree(int n, int[][] edges) {

        if (edges.length != n - 1) {
            return false;
        }

        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {

            if (!union(edge[0], edge[1])) {
                return false;
            }
        }

        return true;
    }

    private boolean union(int a, int b) {

        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) {
            return false;
        }

        parent[rootB] = rootA;

        return true;
    }

    private int find(int x) {

        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }
}