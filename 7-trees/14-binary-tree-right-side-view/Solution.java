

public class Solution {
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> result = new ArrayList<>();

    if (root == null) {
      return new ArrayList<>();
    }

    Deque<TreeNode> queue = new ArrayDeque<>();
    queue.addLast(root);

    while (!queue.isEmpty()) {
      int size = queue.size();

      for (int i = 0; i < size; i++) {
        TreeNode node = queue.removeFirst();

        if (node.left != null) {
          queue.addLast(node.left);
        }

        if (node.right != null) {
          queue.addLast(node.right);
        }

        if (i == size - 1) {
          result.add(node.val);
        }
      }
    }

    return result;
  }
}
