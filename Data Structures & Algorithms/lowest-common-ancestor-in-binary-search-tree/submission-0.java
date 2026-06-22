class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode temp = root;
        TreeNode realp = p;
        TreeNode realq = q;
        HashMap<TreeNode,TreeNode> ancestor = new HashMap<>();
        Deque<TreeNode> nodes = new ArrayDeque<>();
        ancestor.put(root,root);
        nodes.push(root);
        while(!nodes.isEmpty()){
            temp = nodes.pop();
            if(temp.val ==p.val)realp = temp;
            if(temp.val ==q.val)realq = temp;
            if(temp.left!=null){
                ancestor.put(temp.left,temp);
                nodes.push(temp.left);
            }
            if(temp.right!=null){
                ancestor.put(temp.right,temp);
                nodes.push(temp.right);
            }
        }
        //if(ancestor.get(root.left)!=p) System.out.println("fail");
        TreeNode target = realp;
        Deque<TreeNode>p_anc = new ArrayDeque<>();
        Deque<TreeNode>q_anc = new ArrayDeque<>();
        p_anc.push(target);
        while(ancestor.get(target)!=target){
            target = ancestor.get(target);
            p_anc.push(target);
        }
        target = realq;
        q_anc.push(target);
        while(ancestor.get(target)!=target){
            target = ancestor.get(target);
            q_anc.push(target);
        }
        TreeNode ans = root;
        while(!q_anc.isEmpty()&& !p_anc.isEmpty()){
            target = q_anc.pop();
            if(p_anc.pop()!=target)break;
            ans = target;
        }
        return ans;
        //find ancestor list
        //iterate from end, where it doesn't match. the right of that is ans
    }

}
