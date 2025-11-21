

public class Solution {
  public TreeNode invertTree(TreeNode root) {
    // base case
    if (root == null) {
      return root;
    }

    // recursively invert subtrees
    TreeNode leftInverted = invertTree(root.left);
    TreeNode rightInverted = invertTree(root.right);

    // swap
    root.left = rightInverted;
    root.right = leftInverted;

    return root;
  }
}
