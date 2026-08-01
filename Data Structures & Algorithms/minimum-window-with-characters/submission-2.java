class Solution {

    public String minWindow(String s, String t) {
        HashMap<Character, Integer>map = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        HashMap<Character, Integer>window = new HashMap<>();
        int have = 0;
        int need = map.size();
        int[]res = {-1, -1};
        int left = 0;
        int resLen = Integer.MAX_VALUE;
        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            window.put(ch, window.getOrDefault(ch, 0) + 1);

            if(map.containsKey(ch) && window.get(ch).equals(map.get(ch))){
                have++;
            }

            while(have == need){
                if((right - left + 1) < resLen){
                    resLen = (right - left + 1);
                    res[0] = left;
                    res[1] = right;
                }

                char leftchar = s.charAt(left);
                window.put(leftchar, window.get(leftchar) - 1);

                if(map.containsKey(leftchar) && window.get(leftchar) < map.get(leftchar)){
                    have--;
                }
                left++;
            }
        }
        return resLen == Integer.MAX_VALUE? "": s.substring(res[0], res[1] + 1);
    }
}
