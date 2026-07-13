class Solution {
    public int countSubstrings(String s) {
        int left = 0;
        int right = 0;
        int res = 0;

        for(int i = 0; i < s.length(); i++){
            left  = right = i;

            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                res++;
                left--;
                right++;
            }
            left = i;
            right = i + 1;

            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                res++;
                left--;
                right++;
            }
        }
        return res;
    }
}
