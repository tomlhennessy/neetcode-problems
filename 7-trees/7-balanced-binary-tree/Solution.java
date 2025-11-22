

public class Solution {
  public boolean isBalanced(TreeNode root) {
    return dfs(root) != -1;
  }

  private int dfs(TreeNode node) {
    if (node == null) { return 0; }

    int leftHeight = dfs(node.left);
    if (leftHeight == -1) {
      return -1;
    }

    int rightHeight = dfs(node.right);
    if (rightHeight == -1) {
      return -1;
    }

    if (Math.abs(left - right) > 1) {
      return -1;
    }

    return 1 + Math.max(leftHeight, rightHeight);
  }
}
