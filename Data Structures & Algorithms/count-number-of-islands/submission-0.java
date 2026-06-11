class Solution {
    static int[][] direction = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfs(char[][] grid, int i, int j) {
        grid[i][j] = '0'; 
        for(int[] dir : direction) {
            int rowdash = i + dir[0];
            int coldash = j + dir[1];

            if(rowdash < 0 || coldash < 0 || rowdash >= grid.length || coldash >= grid[0].length || grid[rowdash][coldash] != '1') {
                continue;
            }

            dfs(grid, rowdash, coldash);
        }
    }
}
