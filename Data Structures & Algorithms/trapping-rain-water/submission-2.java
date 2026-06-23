class Solution {
    public int trap(int[] height) {
        int m = height.length - 1;
        int left = 0;
        int right = m;
        int leftmax = 0;
        int rightmax = height[m];
        int water = 0;
        while(left < right){
            if(height[left] < height[right]){
                if(leftmax <= height[left]){
                    leftmax = height[left];
                }else{
                    water += leftmax - height[left];
                }
                left++;
            }else{
                if(rightmax <= height[right]){
                    rightmax = height[right];
                }else{
                    water += rightmax - height[right];
                }
                right--;
            }
        }
        return water;
    }
}
