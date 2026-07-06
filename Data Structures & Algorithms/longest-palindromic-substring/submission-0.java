class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String res = "";
        int resLength = 0;

        for (int i = 0; i < n; i++) {

            // Odd length palindrome
            int left = i;
            int right = i;

            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > resLength) {
                    res = s.substring(left, right + 1);
                    resLength = right - left + 1;
                }
                left--;
                right++;
            }

            // Even length palindrome
            left = i;
            right = i + 1;

            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > resLength) {
                    res = s.substring(left, right + 1);
                    resLength = right - left + 1;
                }
                left--;
                right++;
            }
        }

        return res;
    }
}