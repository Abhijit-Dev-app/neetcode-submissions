class Solution {
    public int characterReplacement(String s, int k){
        HashMap<Character, Integer>map = new HashMap<>();
        int left = 0;
        int result = 0;
        int maxCount = 0;

        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxCount = Math.max(maxCount, map.get(ch));

            while((right - left + 1)  - maxCount > k){
                char c = s.charAt(left);
                map.put(c, map.get(c) - 1);
                left++;
            }
            result = Math.max(result, (right - left + 1));
        }
        return result;
    }
}