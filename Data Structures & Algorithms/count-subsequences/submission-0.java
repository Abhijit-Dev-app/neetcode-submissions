class Solution {
    public class Pair{
        int row;
        int col;
        public Pair(int r, int c){
            this.row = r;
            this.col = c;
        }
        @Override
        public boolean equals(Object o){
            if(this == o) return true;
            if(!(o instanceof Pair)) return false;
            Pair p = (Pair)o;
            return p.row == row && p.col == col;
        }
        @Override
        public int hashCode(){
            return Objects.hash(row, col);
        }
    }
    public int numDistinct(String s, String t) {
        HashSet<Pair>visited = new HashSet<>();
        int[][]dp = new int[s.length()][t.length()];
        int ans = dfs(s, t, 0, 0, visited, dp);
        return ans;
    }
    public int dfs(String s, String t, int i, int j, HashSet<Pair>visited, int[][]dp){
        if(j == t.length()){
            return 1;
        }
        if(i == s.length()){
            return 0;
        }
        if(visited.contains(new Pair(i, j))){
            return dp[i][j];
        }
        if(s.charAt(i) == t.charAt(j)){
            dp[i][j] = dfs(s, t, i + 1, j + 1, visited, dp) + dfs(s, t, i + 1, j, visited, dp);
        }else{
            dp[i][j] = dfs(s, t, i + 1, j, visited, dp);
        }
        visited.add(new Pair(i, j));
        return dp[i][j];
    }
}
