class Solution {
    private static boolean pacific, atlantic;
    private static int[][]directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>>res = new ArrayList<>();
        for(int i = 0;i<heights.length;i++){
            for(int j = 0;j<heights[0].length;j++){
                pacific = false;
                atlantic = false;
                dfs(heights, i, j, Integer.MAX_VALUE);
                if(pacific && atlantic){
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }
    public static void dfs(int[][]heights, int i, int j, int val){
        if(i < 0 || j < 0){
            pacific = true;
            return;
        }
        if(i >= heights.length || j >= heights[0].length){
            atlantic = true;
            return;
        }
        if(heights[i][j] > val){
            return;
        }
        int temp = heights[i][j];
        heights[i][j] = Integer.MAX_VALUE;
        for(int[]dir:directions){
            int rowdash = i + dir[0];
            int coldash = j + dir[1];
            dfs(heights, rowdash, coldash, temp);
            if(pacific && atlantic){
                break;
            }

        }
        heights[i][j] = temp;
    }
}
