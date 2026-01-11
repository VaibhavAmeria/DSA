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
    void helper (TreeNode root, List<Integer> inorderTraversal) {
        if (root == null) {
            return;
        }

        helper(root.left, inorderTraversal);
        inorderTraversal.add(root.val);
        helper(root.right, inorderTraversal);
    }
    public boolean isValidBST(TreeNode root) {
        List<Integer> inorderTraversal = new ArrayList <>();
        helper (root, inorderTraversal);

        // to validate check if inorderTraversal is in sorted order, if yes then true else false
        int prev = inorderTraversal.get(0);
        for (int i = 1; i < inorderTraversal.size(); i++) {
            int val = inorderTraversal.get(i);
            if (prev >= val) {
                return false;
            }
            prev = val;
        }
        return true;
   }
}