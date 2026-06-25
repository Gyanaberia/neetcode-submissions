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
    int counter = 0;
    int ans = 0;
    public int kthSmallest(TreeNode root, int k) {
        counter = k;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root){
        if(root==null)return;
            dfs(root.left);
        if(--counter==0)ans = root.val;
            dfs(root.right);
        return;
    }


}
