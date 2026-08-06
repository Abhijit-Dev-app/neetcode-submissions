class Solution {
    public int appendCharacters(String s, String t) {
        // To be within bound
        int k = 0;

        for(char c: s.toCharArray()){
            if(k < t.length() && t.charAt(k) == c){
                k++;
            }
        }
        // if(k == s.length() - 1){
        //     return 0;
        // }

        return (t.length() - k);
    }
}