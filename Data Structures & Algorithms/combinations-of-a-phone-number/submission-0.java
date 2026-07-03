class Solution {
    private List<String> result;

    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        String[] number = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        backtrack(0, digits, number, "");
        return result;
    }

    private void backtrack(int i, String digits, String[] number, String curr) {
        if (i == digits.length()) {
            result.add(curr);
            return;
        }

        int digit = digits.charAt(i) - '0';

        for (int j = 0; j < number[digit].length(); j++) {
            backtrack(i + 1, digits, number,
                    curr + number[digit].charAt(j));
        }
    }
}