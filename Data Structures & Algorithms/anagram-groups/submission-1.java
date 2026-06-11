class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>>result = new HashMap<>();
        for(String str : strs){
            int[]count = new int[26];
            for(int i = 0;i<str.length();i++){
                count[str.charAt(i) - 'a']++;
            }
            String key = Arrays.toString(count);
            result.putIfAbsent(key, new ArrayList<>());
            result.get(key).add(str);
        }
        return new ArrayList<>(result.values()); 
    }
}
