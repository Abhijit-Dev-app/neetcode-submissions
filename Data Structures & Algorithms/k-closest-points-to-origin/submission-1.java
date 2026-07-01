
class Solution {
    class Pair {
        double val;   
        int[] arr;    

        Pair(double dis, int[] num) {
            this.val = dis;
            this.arr = num;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        int coordinatex = 0;
        int coordinatey = 0;

        Pair[] pair = new Pair[points.length];
        for (int i = 0; i < points.length; i++) {
            int dx = points[i][0] - coordinatex;
            int dy = points[i][1] - coordinatey;
            double dist = Math.sqrt(dx * dx + dy * dy);
            pair[i] = new Pair(dist, points[i]);
        }

        Arrays.sort(pair, (a, b) -> Double.compare(a.val, b.val));

        int[][] ans = new int[k][];
        for (int i = 0; i < k; i++) {
            ans[i] = pair[i].arr;
        }
        return ans;
    }
}
