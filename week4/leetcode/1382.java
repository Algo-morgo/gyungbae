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
    List<Integer> values;
    //중위 순회
    void inOrder(TreeNode root){
        if(root==null) {
            return;
        }

        inOrder(root.left);
        values.add(root.val);
        inOrder(root.right);
    }

    //중간 기준 왼쪽, 오른쪽 노드 재귀를 통해 생성
    TreeNode balance(int start, int end){
        if(start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(values.get(mid));
        root.left = balance(start, mid - 1);
        root.right = balance(mid + 1, end);
        return root;
    }

    public TreeNode balanceBST(TreeNode root) {
        values = new ArrayList();
        inOrder(root);
        return balance(0, values.size() - 1);
    }    
}