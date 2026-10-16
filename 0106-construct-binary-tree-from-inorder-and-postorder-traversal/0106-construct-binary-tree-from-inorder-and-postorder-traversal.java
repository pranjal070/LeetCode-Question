import java.util.*;

class Solution {
    int postIndex;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        postIndex = postorder.length - 1;

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return solve(inorder, postorder, 0, inorder.length - 1);
    }

    public TreeNode solve(int[] inorder, int[] postorder, int start, int end) {

        if (start > end) {
            return null;
        }

        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        int index = map.get(rootVal);
        root.right = solve(inorder, postorder, index + 1, end);
        root.left = solve(inorder, postorder, start, index - 1);

        return root;
    }
}