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
    TreeNode solve (int preStart, int postStart, int preEnd, int [] preOrder, int [] postOrder) {
        if (preStart > preEnd) {
            return null;
        }
        TreeNode root = new TreeNode (preOrder[preStart]);
        if (preStart == preEnd) {
            return root;
        }
        int nextNode = preOrder[preStart+1];
        int j = postStart;
        while (postOrder[j] != nextNode) {
            j++;
        }
        int num = j-postStart+1;
        root.left = solve(preStart+1, postStart, preStart+num, preOrder, postOrder);
        root.right = solve(preStart+num+1, j+1, preEnd, preOrder, postOrder);

        return root;
    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return solve (0, 0, preorder.length-1, preorder, postorder);
    }
}