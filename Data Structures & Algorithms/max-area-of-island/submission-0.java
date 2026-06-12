class Solution {

    private final int[][] directions = {
        {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };

    public int maxAreaOfIsland(int[][] grid) {

        int max = 0;

        int m = grid.length;
        int n = grid[0].length;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {

                if (grid[row][col] == 1) {
                    int area = dfs(row, col, grid);
                    max = Math.max(max, area);
                }
            }
        }

        return max;
    }

    private int dfs(int row, int col, int[][] grid) {

        if (row < 0 || row >= grid.length ||
            col < 0 || col >= grid[0].length ||
            grid[row][col] == 0) {
            return 0;
        }

        grid[row][col] = 0;

        int area = 1;

        for (int[] dir : directions) {
            area += dfs(row + dir[0], col + dir[1], grid);
        }

        return area;
    }
}