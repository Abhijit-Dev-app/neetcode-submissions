class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[]parent = new int[n + 1];

        for(int i = 0;i <= n; i++){
            parent[i] = i;
        }
        for(int[]edge: edges){
            if(!union(edge[0], edge[1], parent)){
                return new int[]{edge[0], edge[1]};
            }
        }
        return new int[0];
    }
    public boolean union(int a, int b, int[]parent){
        int parenta = find(a, parent);
        int parentb = find(b, parent);

        if(parenta == parentb){
            return false;
        }
        parent[parentb] = parenta;
        return true;
    }
    public int find(int a, int[]parent){
        if(parent[a] != a){
            parent[a]  = find(parent[a], parent);
        }
        return parent[a];
    }
}
