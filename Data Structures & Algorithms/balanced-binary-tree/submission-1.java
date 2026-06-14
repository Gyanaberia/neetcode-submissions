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
    public boolean isBalanced(TreeNode root) {
        if(root==null)return true;
        if(!isBalanced(root.left) || !isBalanced(root.right))return false;
        else if(Math.abs(maxDepth(root.left)-maxDepth(root.right))<=1)return true;
        return false;
    };
    public int maxDepth(TreeNode root) {
        if(root==null)return 0;
        else if(root.left==null && root.right==null)return 1;
        else if(root.left==null) return maxDepth(root.right)+1;
        else if(root.right==null)return maxDepth(root.left)+1;
        else return Math.max(maxDepth(root.right),maxDepth(root.left))+1;        
    }

}
