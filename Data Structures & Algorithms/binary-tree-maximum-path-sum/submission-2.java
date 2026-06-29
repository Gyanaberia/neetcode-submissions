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
    Map<TreeNode, Integer>maxVal = new HashMap<>();
    public int maxPathSum(TreeNode root) {
        if(root.right==null && root.left==null){
            maxVal.put(root,root.val);
            return root.val;
        }
        int leftVal = root.val;
        int rightVal = root.val;
        int leftSum = -1001;
        int rightSum = -1001;
        if(root.left!=null){
            leftSum = maxPathSum(root.left);
            leftVal+=Math.max(maxVal.get(root.left),0);
        }
        if(root.right!=null){
            rightSum = maxPathSum(root.right);
            rightVal+=Math.max(maxVal.get(root.right),0);
        }
        maxVal.put(root,Math.max(leftVal,rightVal));
        return Math.max(leftVal+rightVal-root.val,Math.max(leftSum,rightSum));
        }

}
