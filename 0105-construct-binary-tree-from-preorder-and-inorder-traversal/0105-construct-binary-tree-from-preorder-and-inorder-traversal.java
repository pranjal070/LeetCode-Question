class Solution {
    int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return solve(preorder, inorder, 0, inorder.length - 1);
    }

    public TreeNode solve(int[] preorder, int[] inorder, int start, int end) {

        if (start > end) {
            return null;
        }

        // First element of preorder is the root
        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        // Find root in inorder
        int index = start;
        while (index <= end && inorder[index] != rootVal) {
            index++;
        }

        // Build left subtree
        root.left = solve(preorder, inorder, start, index - 1);

        root.right = solve(preorder, inorder, index + 1, end);

        return root;
    }
}