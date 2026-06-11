class Solution {
    private static boolean[][]pacific;
    private static boolean[][]atlantic;
    private static int[][]directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        pacific = new boolean[heights.length][heights[0].length];
        atlantic = new boolean[heights.length][heights[0].length];
        List<List<Integer>>res = new ArrayList<>();
        for(int i = 0;i<heights[0].length;i++){
            dfs(heights, 0, i, pacific);
            dfs(heights, heights.length - 1, i, atlantic);
        }
        for(int i = 0;i < heights.length;i++){
            dfs(heights, i, 0, pacific);
            dfs(heights, i, heights[0].length - 1, atlantic);
        }
        for(int i = 0;i<heights.length;i++){
            for(int j = 0;j<heights[0].length; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }
    public static void dfs(int[][]heights, int i, int j, boolean[][]ocean){
        ocean[i][j] = true;
        for(int[]dir: directions){
            int rowdash = i + dir[0];
            int coldash = j + dir[1];
            if(rowdash >= 0 && coldash >= 0 && rowdash < heights.length && coldash < heights[0].length && !ocean[rowdash][coldash] && heights[rowdash][coldash] >= heights[i][j]){
                dfs(heights, rowdash, coldash, ocean);
            }
        }
    }
}
