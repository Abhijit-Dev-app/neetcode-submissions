class Solution {
    private int fl;
    public int characterReplacement(String s, int k) {
        int max = 0;
        for (char c = 'A'; c <= 'Z'; c++) {
            int i = 0;
            int j = 0;
            int temp = k;
            while (j < s.length()) {
                if (s.charAt(j) != c) {
                    temp--;
                }
                while (temp < 0) {
                    if (s.charAt(i) != c) {
                        temp++;
                    }
                    i++;
                }
                max = Math.max(max, j - i + 1);
                j++;
            }
        }
        return max;
    }
}