class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       List<Integer>[]graph = new ArrayList[numCourses];
       for(int i = 0;i<numCourses;i++){
        graph[i] = new ArrayList<>();
       }
       for(int[]arr: prerequisites){
        graph[arr[1]].add(arr[0]);
       }
       int[]visited = new int[numCourses];
       for(int traverse = 0;traverse < numCourses; traverse++){
            if(!dfs(traverse,graph,visited)){
                return false;
            }
       }
       return true;
    }
    public boolean dfs(int course, List<Integer>[]graph, int[]visited){
        if(visited[course] == 1){
            return false;
        }
        if(visited[course] == 2){
            return true;
        }
        visited[course] = 1;

        for (int next : graph[course]) {
            if (!dfs(next, graph, visited)) {
                return false;
            }
        }
        visited[course] = 2;
        return true;
        
    }
}
