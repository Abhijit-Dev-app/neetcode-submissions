class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left  = 1;
        int right = 0;
        for(int item : piles){
            right = Math.max(item, right);
        }
        int ans = right;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(updateMid(mid, piles, h)){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return ans;
    }
    public boolean updateMid(int mid, int[]piles, int h){
        long count = 0;
        for(int item : piles){
            count += (item + mid -1L)/mid;
            if(count > h){
                return false;
            }
        }
        return true;
    }
}
// class Solution {
//     public int minEatingSpeed(int[] piles, int h) {
//         int left = 1;
//         int right = 0;

//         for (int pile : piles) {
//             right = Math.max(right, pile);
//         }

//         int ans = right;

//         while (left <= right) {
//             int mid = left + (right - left) / 2;

//             if (updateMid(mid, piles, h)) {
//                 ans = mid;
//                 right = mid - 1;
//             } else {
//                 left = mid + 1;
//             }
//         }

//         return ans;
//     }

//     public boolean updateMid(int mid, int[] piles, int h) {
//         long count = 0;

//         for (int pile : piles) {
//             count += (pile + mid - 1L) / mid;

//             if (count > h) {
//                 return false;
//             }
//         }

//         return true;
//     }
// }