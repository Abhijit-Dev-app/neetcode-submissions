class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs.length == 0) return result;

        if (strs.length == 1) {
            result.add(new ArrayList<>(Arrays.asList(strs[0])));
            return result;
        }

        boolean[] visited = new boolean[strs.length];
        Arrays.fill(visited, false);

        for (int i = 0; i < strs.length; i++) {
            if (visited[i]) continue;

            ArrayList<String> list = new ArrayList<>();
            list.add(strs[i]);
            visited[i] = true;

            for (int j = i + 1; j < strs.length; j++) {
                if (!visited[j] && isAnagram(strs[i], strs[j])) {
                    list.add(strs[j]);
                    visited[j] = true;
                }
            }

            result.add(list);
        }

        return result;
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int val : count) {
            if (val != 0) return false;
        }

        return true;
    }
}
