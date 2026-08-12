class Solution {
    private List<List<String>> result;

    public List<List<String>> partition(String s) {
        result = new ArrayList<>();

        Helper(s, 0, new ArrayList<>());

        return result;
    }

    private void Helper(String s, int start, List<String> part) {
        if (start == s.length()) {
            result.add(new ArrayList<>(part));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {

                part.add(s.substring(start, i + 1));

                Helper(s, i + 1, part);

                part.remove(part.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}