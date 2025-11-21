

class Solution {
  private int maxDiameter = 0;

  public int diameterOfBinaryTree(TreeNode root) {
    dfs(root);
    return maxDiameter;
  }

  private int dfs(TreeNode node) {
    if (node = null) { return 0; }

    int leftDepth = dfs(node.left);
    int rightDepth = dfs(node.right);

    int candidate = leftDepth + rightDepth;
    maxDiameter = Math.max(candidate, maxDiameter);

    return 1 + Math.max(leftDepth, rightDepth);
  }
}
