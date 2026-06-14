class Solution {
    private List<Integer> order;
    private boolean hasCycle;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        order = new ArrayList<>();
        hasCycle = false;

        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] pre : prerequisites) {
            graph[pre[1]].add(pre[0]);
        }

        int[] visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                dfs(i, visited, graph);
            }
        }

        if (hasCycle) {
            return new int[0];
        }

        Collections.reverse(order);

        int[] ans = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            ans[i] = order.get(i);
        }

        return ans;
    }

    private void dfs(int node, int[] visited, List<Integer>[] graph) {
        if (hasCycle) return;

        if (visited[node] == 1) {
            hasCycle = true;
            return;
        }

        if (visited[node] == 2) {
            return;
        }

        visited[node] = 1; 

        for (int nei : graph[node]) {
            dfs(nei, visited, graph);
        }

        visited[node] = 2; 
        order.add(node);
    }
}