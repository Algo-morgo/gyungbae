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
class Solution {
    int sum = 0;
    //오른쪽부터 순회해야 순차적으로 누적
    void dfs(TreeNode node) {
        if (node.right != null) {
            dfs (node.right);
        }

        int tmp = node.val;
        node.val = sum + tmp;
        sum = node.val;

        if (node.left != null) {
            dfs(node.left);
        }
    }

    public TreeNode bstToGst(TreeNode root) {
        if (root != null) {
            dfs(root);
        }

        return root;
    }
}