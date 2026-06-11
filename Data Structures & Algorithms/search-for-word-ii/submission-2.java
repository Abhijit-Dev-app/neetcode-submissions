public class TrieNode {
    HashMap<Character, TrieNode> children;
    boolean wordend;

    public TrieNode() {
        children = new HashMap<>();
        wordend = false;
    }

    public void addword(String word) {
        TrieNode cur = this;
        for (char c : word.toCharArray()) {
            cur.children.putIfAbsent(c, new TrieNode());
            cur = cur.children.get(c);
        }
        cur.wordend = true;
    }
}

class Solution {
    private HashSet<String> res;
    private boolean[][] visit;

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            root.addword(word);
        }

        int row = board.length;
        int col = board[0].length;
        res = new HashSet<>();
        visit = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dfs(board, i, j, "", root);
            }
        }

        return new ArrayList<>(res);
    }

    public void dfs(char[][] board, int i, int j, String word, TrieNode root) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visit[i][j] || !root.children.containsKey(board[i][j])) {
            return;
        }

        char c = board[i][j];
        visit[i][j] = true;
        root = root.children.get(c);
        word += c;

        if (root.wordend) {
            res.add(word);
        }

        dfs(board, i + 1, j, word, root);
        dfs(board, i - 1, j, word, root);
        dfs(board, i, j + 1, word, root);
        dfs(board, i, j - 1, word, root);

        visit[i][j] = false;
    }
}
