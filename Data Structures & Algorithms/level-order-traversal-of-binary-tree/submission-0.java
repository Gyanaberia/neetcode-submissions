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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans= new ArrayList<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        if(root==null)return new ArrayList<>();
        nodes.offer(root);
        while(!nodes.isEmpty()){
            Queue<TreeNode> child = new LinkedList<>();
            List<Integer>values = new ArrayList<>();
            while(!nodes.isEmpty()){
                TreeNode temp = nodes.poll();
                values.add(temp.val);
                if(temp.left!=null)child.offer(temp.left);
                if(temp.right!=null)child.offer(temp.right);
            }
            ans.add(values);
            nodes = child;
        }
        return ans;
    }
}
