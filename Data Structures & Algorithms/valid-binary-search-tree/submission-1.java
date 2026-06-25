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
    int minVal = 0;
    int maxVal = 1001;
    public boolean isValidBST(TreeNode root) {
        int[] ans = minmaxTree(root);
        if(ans[1] == 1001)return false;
        return true;
    }

    int[] minmaxTree(TreeNode root){

        int[]ans = {0,0};
        if(root.left!=null){
            int[] left = minmaxTree(root.left);
            if(left[1]>=root.val)return new int[]{-1001,1001};
            else ans[0] = left[0];
        }else{
            ans[0] = root.val;
        }
        if(root.right!=null){
            int[] right = minmaxTree(root.right);
            if(right[0]<=root.val)return new int[]{-1001,1001};
            else ans[1] = right[1];
        }else{
            ans[1] = root.val;
        }
        return ans;
    }

}
