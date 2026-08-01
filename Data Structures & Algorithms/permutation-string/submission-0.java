class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> map1 = new HashMap<>();

        int left = 0;

        for (int right = 0; right < s2.length(); right++) {

            char ch = s2.charAt(right);
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);

            if (right - left + 1 > s1.length()) {

                char remove = s2.charAt(left);

                map1.put(remove, map1.get(remove) - 1);

                if (map1.get(remove) == 0)
                    map1.remove(remove);

                left++;
            }

            if (right - left + 1 == s1.length()) {
                if (map.equals(map1))
                    return true;
            }
        }

        return false;
    }
}