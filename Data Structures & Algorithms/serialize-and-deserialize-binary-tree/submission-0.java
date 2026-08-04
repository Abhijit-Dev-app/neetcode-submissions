/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {
    private String Delimiter = ",";
    private String Null = "null";
    public String serialize(TreeNode root) {
        StringBuilder sb  = new StringBuilder("");
        preorder(root, sb);
        return sb.toString();
    }

    public void preorder(TreeNode root, StringBuilder sb){
        
        if(root == null){
            sb.append(Null).append(Delimiter);
            return;
        }
        sb.append(root.val).append(Delimiter);
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int[]index = {0};
        String[]word = data.split(Delimiter);
        return deserializeHelper(word, index);
    }

    public TreeNode deserializeHelper(String[]data, int[]index){
        if(data[index[0]].equals(Null) || index[0] >=  data.length){
            index[0]++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(data[index[0]++]));
        // index[0] = index[0]++;
        root.left = deserializeHelper(data, index);
        root.right = deserializeHelper(data, index);

        return root;
    }
    
}
