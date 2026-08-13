public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordSet = new HashSet<>(wordDict);
        HashMap<Integer, Boolean>map = new HashMap<>();
        return dfs(s, wordSet, 0, map);
    }

    private boolean dfs(String s, HashSet<String> wordSet, int i, HashMap<Integer, Boolean>map) {
        if (i == s.length()) {
            return true;
        }
        if(map.containsKey(i)){
            return map.get(i);
        }

        for (int j = i; j < s.length(); j++) {
            if (wordSet.contains(s.substring(i, j + 1))) {
                if (dfs(s, wordSet, j + 1, map)) {
                    map.put(i, true);
                    return true;
                }
            }
        }
        map.put(i, false);
        return false;
    }
}