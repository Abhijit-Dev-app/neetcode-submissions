class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        int[] state = new int[numCourses]; // 0=unvisited, 1=visiting, 2=visited

        // Build graph
        for (int[] dir : prerequisites) {
            graph.putIfAbsent(dir[0], new HashSet<>());
            graph.get(dir[0]).add(dir[1]);
        }

        // DFS for each course
        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, graph, state)) {
                return false; // cycle detected
            }
        }
        return true;
    }

    private boolean dfs(int course, HashMap<Integer, HashSet<Integer>> graph, int[] state) {
        if (state[course] == 1) return true;  
        if (state[course] == 2) return false;

        state[course] = 1; 

        if (graph.containsKey(course)) {
            for (int prereq : graph.get(course)) {
                if (dfs(prereq, graph, state)) {
                    return true;
                }
            }
        }

        state[course] = 2; 
        return false;
    }
}
