class Solution {
    private List<String> result;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        Generator(n, 0, 0, "");
        return result;
    }

    public void Generator(int n, int open, int closed, String curr) {
        if (open == n && closed == n) {
            result.add(curr);
            return;
        }

        if (open < n) {
            Generator(n, open + 1, closed, curr + "(");
        }

        if (closed < open) {
            Generator(n, open, closed + 1, curr + ")");
        }
    }
}
