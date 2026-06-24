class Solution {
    class Bar{
        int height;
        int index;
        Bar(int height, int index){
            this.height = height;
            this.index = index;
        }
    }
    public int largestRectangleArea(int[] heights) {
        Stack<Bar>stack = new Stack<>();
        int maxArea= 0;

        for(int i = 0; i < heights.length; i++){
            int index = i;

            while(!stack.isEmpty() && stack.peek().height > heights[i]){
                Bar top = stack.pop();
                int height = top.height;
                int area = height *(i - top.index);
                maxArea = Math.max(maxArea, area);
                index = top.index;
            }
            stack.push(new Bar(heights[i], index));
        }
        while(!stack.isEmpty()){
            Bar top = stack.pop();
            int area = top.height * (heights.length  - top.index);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}
