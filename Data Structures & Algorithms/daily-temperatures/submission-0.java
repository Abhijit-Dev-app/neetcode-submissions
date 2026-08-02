class Solution {
    class Pair{
        int val;
        int ind;
        public Pair(int va, int in){
            this.val = va;
            this.ind = in;
        }
    }
    public int[] dailyTemperatures(int[] temperatures) {
        int[]result = new int[temperatures.length];
        Stack<Pair>stack = new Stack<>();

        for(int i = 0; i < temperatures.length; i++){
            int temp  = temperatures[i];
            while(!stack.isEmpty() && temp > stack.peek().val){
                Pair p = stack.pop();
                result[p.ind] = i - p.ind;
            }
            stack.push(new Pair(temp, i));
        }
        return result;
    }
}
