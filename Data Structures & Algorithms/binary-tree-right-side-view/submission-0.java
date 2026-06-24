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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans= new ArrayList<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        if(root==null)return new ArrayList<>();
        nodes.offer(root);
        while(!nodes.isEmpty()){
            Queue<TreeNode> child = new LinkedList<>();
            int values = 0;
            while(!nodes.isEmpty()){
                TreeNode temp = nodes.poll();
                values = temp.val;
                if(temp.left!=null)child.offer(temp.left);
                if(temp.right!=null)child.offer(temp.right);
            }
            ans.add(values);
            nodes = child;
        }
        return ans;       
    }
}
