class PrefixTree {
    
    public class TrieNode{
        private TrieNode[]children;
        private boolean wordend;
        private TrieNode(){
            children = new TrieNode[26];
            wordend = false;
        }
    }
    private TrieNode root;
    public PrefixTree() {
       root = new TrieNode(); 
    }

    public void insert(String word) {
        TrieNode cur = root;
        for(int i = 0;i<word.length();i++){
            char c = word.charAt(i);
            if(cur.children[c - 'a'] == null){
                cur.children[c - 'a']  = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.wordend = true;
    }

    public boolean search(String word) {
        return dfs(word, root, 0);
    }

    public boolean startsWith(String prefix) {
        return dfsS(prefix, root, 0);
    }
    public boolean dfsS(String prefix, TrieNode root, int j){
        TrieNode cur = root;
        if(j == prefix.length()){
            return true;
        }
        char c = prefix.charAt(j);
        if(cur.children[c - 'a'] == null){
            return false;
        }
        cur = cur.children[c - 'a'];
        boolean ans = dfsS(prefix, cur, j + 1);
        return ans;
    }
    public boolean dfs(String word, TrieNode root, int j){
        TrieNode cur = root;
        if(j  == word.length()){
            return cur.wordend;
        }
        char c = word.charAt(j);
        if(cur.children[c - 'a'] == null){
            return false;
        }
        cur = cur.children[c - 'a'];
       return dfs(word, cur, j + 1);
    }
}
