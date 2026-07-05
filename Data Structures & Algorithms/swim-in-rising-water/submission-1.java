class Solution {

    class Pair {
        int row, col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Pair)) return false;

            Pair p = (Pair) obj;
            return row == p.row && col == p.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

    public int swimInWater(int[][] grid) {

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        pq.add(new int[]{grid[0][0], 0, 0});

        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};

        HashSet<Pair> visited = new HashSet<>();
        visited.add(new Pair(0,0));

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int val = curr[0];
            int r = curr[1];
            int c = curr[2];

            if (r == grid.length - 1 && c == grid[0].length - 1)
                return val;

            for (int[] d : directions) {

                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nr >= grid.length ||
                    nc < 0 || nc >= grid[0].length ||
                    visited.contains(new Pair(nr, nc)))
                    continue;

                visited.add(new Pair(nr, nc));

                pq.add(new int[]{
                        Math.max(val, grid[nr][nc]),
                        nr,
                        nc
                });
            }
        }

        return -1;
    }
}