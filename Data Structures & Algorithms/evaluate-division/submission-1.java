class Solution {
    class Pair{
        String c;
        double val;

        public Pair(String c, double val){
            this.c = c;
            this.val = val;
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Pair>>map = new HashMap<>();

        // creating a hashmap 
        for(int i = 0; i < equations.size(); i++){
            List<String>lst= equations.get(i);
            String ch1 = lst.get(0);
            String ch2 = lst.get(1);
            map.computeIfAbsent(ch1, k-> new ArrayList<>()).add(new Pair(ch2, values[i]));
            map.computeIfAbsent(ch2, k-> new ArrayList<>()).add(new Pair(ch1, 1/ values[i]));
        }
        // result
        double[]result = new double[queries.size()];
        int i = 0;
        for(List<String>query: queries){
            double ans  = Bfs(query.get(0), query.get(1), map);
            result[i++] = ans;
        }
        return result;
    }

    public double Bfs(String src, String target, Map<String, List<Pair>> map) {

    if (!map.containsKey(src) || !map.containsKey(target))
        return -1.0;

    Queue<Pair> queue = new LinkedList<>();
    Set<String> visited = new HashSet<>();

    queue.offer(new Pair(src, 1.0));
    visited.add(src);

    while (!queue.isEmpty()) {

        Pair curr = queue.poll();

        String node = curr.c;
        double value = curr.val;

        if (node.equals(target))
            return value;

        for (Pair next : map.get(node)) {

            if (visited.contains(next.c))
                continue;

            visited.add(next.c);
            queue.offer(new Pair(next.c, value * next.val));
        }
    }

    return -1.0;
}
}